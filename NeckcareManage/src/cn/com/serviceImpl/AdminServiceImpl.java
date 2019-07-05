package cn.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.mapper.AccountsMapper;
import cn.com.mapper.AdminMapper;
import cn.com.mapper.DoctorMapper;
import cn.com.model.Accounts;
import cn.com.model.Admin;
import cn.com.model.AdminExample;
import cn.com.model.AdminExample.Criteria;
import cn.com.model.Doctor;
import cn.com.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	public AccountsMapper accountsMapper;
	@Autowired
	public DoctorMapper doctorMapper;
	@Autowired
	public AdminMapper adminMapper;
	
	@Override
	public List<Accounts> selectUsers() {
		
		return  accountsMapper.selectAllUsers();
	}

	@Override
	public List<Doctor> selectDoctors() {
		
		return doctorMapper.selectDoctors();
	}

	@Override
	public void alterUser(Accounts user) {
		accountsMapper.updateByPrimaryKey(user);
		
	}

	@Override
	public int delete(String id) {
		Integer Id = Integer.parseInt(id);
		int i = accountsMapper.deleteByPrimaryKey(Id);
		return i;
	}

	@Override
	public Accounts selectUsersById(String id) {
		int Id = Integer.parseInt(id);
		return accountsMapper.selectByPrimaryKey(Id);
	}

	@Override
	public int deleteDoctor(String id) {
				
		return doctorMapper.deleteByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public void addDoctor(Doctor doc) {
		doctorMapper.insert(doc);
		
	}

	@Override
	public void update(Doctor doc) {
		doctorMapper.updateByPrimaryKey(doc);
		
	}

	@Override
	public Doctor selectDoctorsById(int id) {
		return doctorMapper.selectByPrimaryKey(id);
	}

	@Override
	public Admin selectAdmin(String name) {
		
		return adminMapper.selectByName(name);
		
	}

}
