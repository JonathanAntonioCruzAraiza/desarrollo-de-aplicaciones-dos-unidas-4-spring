package boot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Employer;
import boot.model.Task;
import boot.service.EmployerService;
import boot.service.TaskService;

@Controller
public class EmployerController {

	@Autowired
	private EmployerService employerService;

	@GetMapping("/employees")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "employees";
	}

	@GetMapping("/all-employees")
	public String allEmployees(HttpServletRequest request) {
		request.setAttribute("employees", employerService.finAll());
		request.setAttribute("mode", "MODE_EMPLOYEES");
		return "employees";
	}

	@GetMapping("/new-employer")
	public String newEmployer(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "employees";
	}

	@PostMapping("/save-employer")
	public String saveEmployer(@ModelAttribute Employer employer, BindingResult bindingResult,
			HttpServletRequest request) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = new Date();
		Date hireDate = new Date();
		try {
			birthDate = format.parse(request.getParameter("birthDate"));
			hireDate = format.parse(request.getParameter("hireDate"));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		employer.setBirthDate(birthDate);
		employer.setHireDate(hireDate);

		employerService.save(employer);
		request.setAttribute("employees", employerService.finAll());
		request.setAttribute("mode", "MODE_EMPLOYEES");
		return "employees";
	}

	@GetMapping("/update-employer")
	public String updateEnployer(@RequestParam int empNo, HttpServletRequest request) {
		request.setAttribute("employer", employerService.finOne(empNo));
		request.setAttribute("mode", "MODE_UPDATE");
		return "employees";
	}

	@GetMapping("/delete-employer")
	public String deleteEmployer(@RequestParam int empNo, HttpServletRequest request) {
		employerService.delete(empNo);
		request.setAttribute("employees", employerService.finAll());
		request.setAttribute("mode", "MODE_EMPLOYEES");
		return "employees";
	}

}
