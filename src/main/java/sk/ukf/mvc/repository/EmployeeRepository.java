package sk.ukf.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.ukf.mvc.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findAllByOrderByLastNameAscFirstNameAsc();
}
