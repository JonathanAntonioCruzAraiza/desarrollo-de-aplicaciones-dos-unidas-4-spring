package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Student;
import boot.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public String homestudent(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "students";
	}

	@GetMapping("/all-students")
	public String allStudent(HttpServletRequest request) {
		request.setAttribute("students", studentService.finAll());
		request.setAttribute("mode", "MODE_STUDENTS");
		return "students";
	}

	@GetMapping("/new-student")
	public String newStudent(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "students";
	}

	@PostMapping("/save-student")
	public String saveStudent(@ModelAttribute Student student, BindingResult bindingResult,
			HttpServletRequest request) {
		studentService.save(student);
		request.setAttribute("students", studentService.finAll());
		request.setAttribute("mode", "MODE_STUDENTS");
		return "students";
	}

	@GetMapping("/update-student")
	public String updateStudent(@RequestParam int studentId, HttpServletRequest request) {
		request.setAttribute("student", studentService.finOne(studentId));
		request.setAttribute("mode", "MODE_UPDATE");
		return "students";
	}

	@GetMapping("/delete-student")
	public String deleteStudent(@RequestParam int studentId, HttpServletRequest request) {
		studentService.delete(studentId);
		request.setAttribute("students", studentService.finAll());
		request.setAttribute("mode", "MODE_STUDENTS");
		return "students";
	}

}
