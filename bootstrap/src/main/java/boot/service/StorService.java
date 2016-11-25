package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.StorRepository;
import boot.dao.StudentRepository;
import boot.model.Employer;
import boot.model.Stor;
import boot.model.Student;

@Service @Transactional
public class StorService {

	private final StorRepository storRepository;
	
	public StorService(StorRepository storRepository){
		super();
		this.storRepository=storRepository;
	}
	
	public List<Stor> finAll(){
		List<Stor> stores = new  ArrayList<Stor>();
		for(Stor stor : storRepository.findAll()){
			stores.add(stor);
		}
	
	return stores;
	}
	
	
	
	public void save(Stor stor){
		storRepository.save(stor);
	}
	public void delete(int storId){
		storRepository.delete(storId);
	}
	
	public Stor finOne(int storId){
	return storRepository.findOne(storId);
	}
}
