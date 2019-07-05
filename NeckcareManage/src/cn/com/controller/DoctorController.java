package cn.com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.model.Doctor;
import cn.com.model.Question;
import cn.com.service.DoctorService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@RequestMapping("/searchQuestion")
	public void searchQuestion(ModelMap map,HttpServletResponse response) throws IOException{
		JSONObject jsonObject = new JSONObject();
		List<Question> question=doctorService.searchQuestion();
		JSONArray doctorsjson = JSONArray.fromObject(question);
		
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		jsonObject.put("data", doctorsjson);
		jsonObject.put("count", question.size());
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonObject);
		
	}
	
	@RequestMapping("/jumpAnswerPage")
	public ModelAndView jump(String id){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", id);
		modelAndView.setViewName("answerQuestionPage");
		return modelAndView;
	}
	
	@RequestMapping("/updateQuestion")
	public String updateQuestion(String id,String result){
		Question question2 = new Question(); 
		question2.setId(Integer.parseInt(id));
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(date);
		question2.setResult(result);
		question2.setTag(1);
		doctorService.update(question2);
		return "redirect:/jumpDoctorPage.do";
		
		
	}

}
