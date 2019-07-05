package cn.com.service;

import java.util.List;


import cn.com.model.Accounts;
import cn.com.model.Admin;
import cn.com.model.Doctor;

public interface AdminService {
	
	public List<Accounts> selectUsers();
	
	public List<Doctor> selectDoctors();

	public void alterUser(Accounts user);
	
	public int delete(String id );
	
	public Accounts selectUsersById(String id);

	public int deleteDoctor(String id);

	public void addDoctor(Doctor doc);

	public void update(Doctor doc);

	public Doctor selectDoctorsById(int parseInt);

	public Admin selectAdmin(String name);
}
