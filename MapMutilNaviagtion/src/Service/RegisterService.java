package Service;

import java.util.Date;
import java.util.Random;

import DBManage.DBManage;

//用户注册
public class RegisterService {

	public boolean register(String name,String telphone,String password,String date) {
		Random random=new Random();
		int i=random.nextInt(1000);
		String insertSqlInfo = "insert into accounts (username,tel,password,gender,datetime)values('"+name+"',"+telphone+","+password+","+"'女','"+date+"')";
		System.out.println(insertSqlInfo);
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB(); 
		int retInfo = sqlDbManage.executeUpdate(insertSqlInfo);
		if(retInfo != 0 ){
			sqlDbManage.closeDB();
			return true;
		}
		sqlDbManage.closeDB();
		return false;
	}
}
