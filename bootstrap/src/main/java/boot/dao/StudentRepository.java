package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Student;

public interface StudentRepository  extends CrudRepository<Student,Integer> {

}
