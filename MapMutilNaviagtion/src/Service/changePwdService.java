package Service;


import DBManage.DBManage;

public class changePwdService {
	
	public Boolean changePwd(String username,String pwd){
		//修改sql语句
		String sql = "update accounts set password = '"+pwd+"' where username = '"+username+"'";
		
		System.out.println(sql);//获取DB对象
		DBManage dbManage = DBManage.creatInstance();
		dbManage.connectDB();
		//操作DB
		try {
			int resultSet = dbManage.executeUpdate(sql);
			System.out.println(resultSet);
			if(resultSet>=1)
			{
				dbManage.closeDB();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}
