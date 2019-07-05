package Service;


import java.text.SimpleDateFormat;
import java.util.Date;

import DBManage.DBManage;

public class Setquestion {

	public Boolean setQuestion(String question,String username) {
		
		Date time = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dateFormat.format(time);
		int tag=0;
		//获取sql插入语句
		//String insertSql = "insert into question(username,question,time,tag) values('"+username+"','"+question+"','"+format+"'"+tag+"')";
		String insertSql = "insert into question(username,question,time,tag) values('"+username+"','"+question+"','"+format+"','"+tag+"')";
		System.out.println(insertSql);
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB(); 
		
		//操作DB对象
		try {
			int resultSet = sqlDbManage.executeUpdate(insertSql);
			if(resultSet>0)
			{
				sqlDbManage.closeDB();
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sqlDbManage.closeDB();
		return false;
	}
}
