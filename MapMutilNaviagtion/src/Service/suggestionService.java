package Service;


import java.text.SimpleDateFormat;
import java.util.Date;

import DBManage.DBManage;


public class suggestionService {
	
	public Boolean setSuggestion(String username,String suggestion){
	
		//创建日期
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time =simpleDateFormat.format(date);
		//sql语句
		String sql ="insert into suggestion (username,suggestion,time)values('"+username+"','"+suggestion+"','"+time+"')";
		System.out.println(sql);
		//获取DBMange
		DBManage dbManage = DBManage.creatInstance();
		dbManage.connectDB();
		
		//操作数据库
		try {
			int resulement = dbManage.executeUpdate(sql);
			if(resulement>=1){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbManage.closeDB();
		return false;
	}

}
