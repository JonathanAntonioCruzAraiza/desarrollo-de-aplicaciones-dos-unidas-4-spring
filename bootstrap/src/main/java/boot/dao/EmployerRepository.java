package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Employer;

public interface EmployerRepository extends CrudRepository<Employer, Integer> {

}
