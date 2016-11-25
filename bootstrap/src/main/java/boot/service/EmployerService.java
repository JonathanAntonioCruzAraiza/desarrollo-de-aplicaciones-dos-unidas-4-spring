package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.EmployerRepository;
import boot.dao.StorRepository;
import boot.model.Employer;
import boot.model.Stor;
import boot.model.Task;

@Service @Transactional
public class EmployerService {

private final EmployerRepository employerRepository;
	
	public EmployerService(EmployerRepository emplayerRepository){
		super();
		this.employerRepository=emplayerRepository;
	}
	
	public List<Employer> finAll(){
		List<Employer> employees = new  ArrayList<Employer>();
		for(Employer employer : employerRepository.findAll()){
			employees.add(employer);
		}
	
	return employees;
	}
	
	
	
	public void save(Employer employer){
		employerRepository.save(employer);
	}
	public void delete(int empNo){
		employerRepository.delete(empNo);
	}
	

	
	public  Employer finOne(int empNo){
	return employerRepository.findOne(empNo);
	}
}
