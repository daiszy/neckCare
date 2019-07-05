package Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DBManage.DBManage;
import net.sf.json.JSONArray;

public class searchQuestionService{

	public JSONArray searchQuestion(String username) {
		
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		JSONArray json=new JSONArray();
		//获取sql插入语句
		String searchSql = "select username, question,time,tag,result from question where username='"+username+"'";
		System.out.println(searchSql);
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB(); 
		
		//操作DB对象
		try {
			ResultSet resultSet=sqlDbManage.excuteQuery(searchSql);
			while(resultSet.next()){
				Map<String,Object> map= new HashMap<String, Object>();
				String name=resultSet.getString("username");
				String question=resultSet.getString("question");
				String tag=resultSet.getString("tag");
				String result=resultSet.getString("result");
				String time=resultSet.getString("time");
		
				map.put("question", question);
				map.put("tag", tag);
				map.put("result", result);
				map.put("time", time);
				map.put("name", name);
				list.add(map);
			}
			 json= JSONArray.fromObject(list);
			System.out.println(json+"--------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sqlDbManage.closeDB();
		System.out.println(list.size()+"--------------------");
		return json;
	}

	
	
}