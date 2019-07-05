package Service;

import java.sql.ResultSet;

import DBManage.DBManage;

public class getNeckAngleService {

	public String find(String username) {
		//获取sql查询语句
		String logSql = "select neck_angle from neckstate"
				+ " where username ='"+username+"'";
		//获取DB对象
		DBManage sqlDbManage = DBManage.creatInstance();
		sqlDbManage.connectDB(); 
		
		//操作DB对象
		try {
			ResultSet resultSet = sqlDbManage.excuteQuery(logSql);
			if(resultSet.next())
			{
				sqlDbManage.closeDB();
				return resultSet.getString("neck_angle");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sqlDbManage.closeDB();
		return null;
	}
	
}
