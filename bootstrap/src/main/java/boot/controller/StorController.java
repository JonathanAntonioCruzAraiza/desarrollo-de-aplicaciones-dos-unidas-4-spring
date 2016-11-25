package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Stor;
import boot.model.Task;
import boot.service.StorService;
import boot.service.TaskService;

@Controller
public class StorController {
	
	@Autowired
	private StorService storService;

	@GetMapping("/stores")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "stores";
	}

	@GetMapping("/all-stores")
	public String allStores(HttpServletRequest request) {
		request.setAttribute("stores", storService.finAll());
		request.setAttribute("mode", "MODE_STORES");
		return "stores";
	}

	@GetMapping("/new-stor")
	public String newStor(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "stores";
	}

	
	@PostMapping("/save-stor")
	public String saveStor(@ModelAttribute Stor stor, 
			BindingResult bindingResult, HttpServletRequest request) {
		storService.save(stor);
		request.setAttribute("stores", storService.finAll());
		request.setAttribute("mode", "MODE_STORES");		
		return "stores";
	}
	
	@GetMapping("/update-stor")
	public String updateStor(@RequestParam int storId, HttpServletRequest request) {
	request.setAttribute("stor", storService.finOne(storId));
		request.setAttribute("mode", "MODE_UPDATE");
		return "stores";
	}	
	
	
	@GetMapping("/delete-stor")
	public String deleteStor(@RequestParam int storId, HttpServletRequest request) {
    storService.delete(storId);
	request.setAttribute("stores", storService.finAll());
		request.setAttribute("mode", "MODE_STORES");
		return "stores";
	}	
	
	
}
