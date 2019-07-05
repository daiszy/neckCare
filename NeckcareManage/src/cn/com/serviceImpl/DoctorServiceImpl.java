package cn.com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.mapper.DoctorMapper;
import cn.com.mapper.QuestionMapper;
import cn.com.model.Doctor;
import cn.com.model.Question;
import cn.com.model.QuestionExample;
import cn.com.model.QuestionExample.Criteria;
import cn.com.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	
	@Autowired
	public QuestionMapper questionMapper; 
	@Autowired
	public DoctorMapper doctorMapper; 
	
	
	
	@Override
	public List<Question> searchQuestion() {
		
		return questionMapper.selectAll();
	}
	@Override
	public int update(Question question) {
		return questionMapper.updateByPrimaryKeySelective(question);
	}
	@Override
	public Doctor selectDoctor(String name) {
		return doctorMapper.selectDoctorByname(name);
	}

}
