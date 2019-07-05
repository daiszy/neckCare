package cn.com.controller;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.model.Accounts;
import cn.com.model.Admin;
import cn.com.model.Doctor;
import cn.com.service.AdminService;
import cn.com.service.DoctorService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
public class AdminController {
	@Autowired
	public AdminService adminservice;
	
	@Autowired
	public DoctorService doctorservice;
	
	
	
	
	@RequestMapping(value="/login")
	public ModelAndView login(){
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
		
	}
	@RequestMapping(value="/Jumplogin")
	public String loginService(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if(name.equals("王怀军")){
			//管理员登录
			Admin admin = adminservice.selectAdmin(name);
			if(admin.getPassword().equals(password)){
				 return "redirect:/selectUser.do";
			}else{
				return "密码错误";
			}
		}else{
			//医生登录
			Doctor doctor =doctorservice.selectDoctor(name);
			if(doctor.getPassword().equals(password)){
				//跳转至医生界面
				return "redirect:/jumpDoctorPage.do";
			}else{
				return "密码错误";
			}
		}
				
	}
	
	@RequestMapping(value="/jumpDoctorPage")
	public ModelAndView jumpDoctorPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("DoctorPage");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/selectUser")
	public ModelAndView test(){
		ModelAndView model = new ModelAndView();
		model.setViewName("GearShow");
		return model;
		
	}
	
	@RequestMapping(value="/alterPage")
	public ModelAndView alterPage(String id){
		
		    Accounts user = adminservice.selectUsersById(id);
		    ModelAndView mav = new ModelAndView();
		    mav.addObject("user",user);
	        mav.setViewName("alterUserInfo");
	        return mav;
	}
	
	
	@RequestMapping(value="/deleteUser")
	public String deleteUser(String id){
		ModelAndView mav = new ModelAndView();
		adminservice.delete(id);
		mav.setViewName("user");
		  return "redirect:/selectUser.do";
	}
	
	@RequestMapping(value="alterUser")
	public String alterUser(HttpServletRequest request) throws Exception{
		    request.setCharacterEncoding("UTF-8");
			Accounts user = new Accounts();
			user.setId(Integer.parseInt(request.getParameter("id")));
			user.setUsername(request.getParameter("username"));
			user.setTel(request.getParameter("tel"));
			user.setPassword(request.getParameter("password"));
			user.setGender(request.getParameter("gender"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String format = sdf.format(date);
			user.setDatetime(format);
			adminservice.alterUser(user);
	        return "redirect:/selectUser.do";
	}
	
	@RequestMapping(value="/selectDoctors")
		public void selectDoctors(ModelMap map,HttpServletResponse response,Integer page,String limit) throws IOException{
			JSONObject jsonObject = new JSONObject();
			List<Doctor> doctors = adminservice.selectDoctors();
			JSONArray doctorsjson = JSONArray.fromObject(doctors);
			
			jsonObject.put("code", 0);
			jsonObject.put("msg", "");
			jsonObject.put("data", doctorsjson);
			jsonObject.put("count", doctors.size());
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jsonObject);
	}
	@RequestMapping(value="/AllDoctors")
	public ModelAndView AllDoctors(){		  
		   ModelAndView mav = new ModelAndView();		
	       mav.setViewName("AllDoctors");
	       return mav;
	}
	
	@RequestMapping(value="/deleteDoctor")
	public String deleteDoctor(String id){
		    int i = adminservice.deleteDoctor(id);
	        return "redirect:/AllDoctors.do";
	}
	
	@RequestMapping(value="/jumpAddDoctor")
	public ModelAndView jumpAddDoctor(){
		ModelAndView model = new ModelAndView();
		model.setViewName("addDoctor");
		return model;
		
	}
	
	@RequestMapping(value="/addDoctor")
	public String addDoctor(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		Doctor doc = new Doctor();
		doc.setName(request.getParameter("name"));
		doc.setTel(request.getParameter("tel"));
		doc.setPassword(request.getParameter("password"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String format = sdf.format(date);
		doc.setTime(format);
		adminservice.addDoctor(doc);
		return "redirect:/AllDoctors.do";
	}
	
	@RequestMapping("/alterDoctorPage")
	public ModelAndView alterDoctorPage(String id){
		
		ModelAndView model = new ModelAndView();
		Doctor doctor = adminservice.selectDoctorsById(Integer.parseInt(id));
		model.addObject("doctor",doctor);
		model.setViewName("alterDoctorInfo");
		return model;
	}
	
	@RequestMapping(value="/alterDoctor")
	public String alterDoctor(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		Doctor doc = new Doctor();
		doc.setId(Integer.parseInt(request.getParameter("id")));
		doc.setName(request.getParameter("name"));
		 
		doc.setPassword(request.getParameter("password"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String format = sdf.format(date);
		doc.setTime(format);
		adminservice.update(doc);
		return "redirect:/AllDoctors.do";
	}
	
	
	/**
	 * 显示用户全部信息
	 * @param map
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping("GearShow.do")
	public void GearShow(ModelMap map,HttpServletResponse response,Integer page,String limit) throws IOException{
		JSONObject jsonObject = new JSONObject();
		  List<Accounts> users = adminservice.selectUsers();
		JSONArray usersjson = JSONArray.fromObject(users);
		
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("data", usersjson);
		jsonObject.put("count", users.size());
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject);
		
	}
	
	
	

}
