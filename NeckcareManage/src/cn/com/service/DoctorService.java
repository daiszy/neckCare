package cn.com.service;

import java.util.List;

import cn.com.model.Doctor;
import cn.com.model.Question;

public interface DoctorService {

	List<Question> searchQuestion();

	int update(Question question2);

	Doctor selectDoctor(String name);

}
