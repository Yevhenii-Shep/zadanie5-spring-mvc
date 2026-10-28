package sk.ukf.mvc.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.ukf.mvc.entity.Employee;
import sk.ukf.mvc.service.EmployeeService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private final EmployeeService employeeService;

	// hodnoty pre drop-down list sa nacitaju z application.properties
	@Value("${employee.job-titles}")
	private List<String> jobTitles;

	// hodnoty pre radio buttony (kluc = hodnota v DB, hodnota = popis)
	@Value("#{${employee.employment-types}}")
	private Map<Integer, String> employmentTypes;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// tieto atributy budu v Modeli dostupne pre vsetky sablony tohto Controllera
	@ModelAttribute("jobTitles")
	public List<String> jobTitles() {
		return jobTitles;
	}

	@ModelAttribute("employmentTypes")
	public Map<Integer, String> employmentTypes() {
		return employmentTypes;
	}

	@GetMapping
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.findAll());
		return "employees/list";
	}

	@GetMapping("/{id}")
	public String viewEmployee(@PathVariable Integer id, Model model) {
		model.addAttribute("employee", employeeService.findById(id));
		return "employees/view";
	}

	@GetMapping("/create")
	public String showCreateForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/form";
	}

	@PostMapping
	public String createEmployee(@Valid @ModelAttribute("employee") Employee employee,
								 BindingResult bindingResult,
								 RedirectAttributes redirectAttributes) {
		validateOptions(employee, bindingResult);
		if (bindingResult.hasErrors()) {
			return "employees/form";
		}
		employee.setId(null);
		Employee saved = employeeService.save(employee);
		redirectAttributes.addFlashAttribute("message",
				"Zamestnanec " + saved.getFirstName() + " " + saved.getLastName() + " bol pridaný.");
		return "redirect:/employees";
	}

	@GetMapping("/{id}/edit")
	public String showUpdateForm(@PathVariable Integer id, Model model) {
		model.addAttribute("employee", employeeService.findById(id));
		return "employees/form";
	}

	@PostMapping("/{id}")
	public String updateEmployee(@PathVariable Integer id,
								 @Valid @ModelAttribute("employee") Employee employee,
								 BindingResult bindingResult,
								 RedirectAttributes redirectAttributes) {
		employeeService.findById(id);
		employee.setId(id);
		validateOptions(employee, bindingResult);
		if (bindingResult.hasErrors()) {
			return "employees/form";
		}
		employeeService.save(employee);
		redirectAttributes.addFlashAttribute("message",
				"Zmeny u zamestnanca " + employee.getFirstName() + " " + employee.getLastName() + " boli uložené.");
		return "redirect:/employees/" + id;
	}

	@PostMapping("/{id}/delete")
	public String deleteEmployee(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		Employee employee = employeeService.findById(id);
		employeeService.deleteById(id);
		redirectAttributes.addFlashAttribute("message",
				"Zamestnanec " + employee.getFirstName() + " " + employee.getLastName() + " bol odstránený.");
		return "redirect:/employees";
	}

	// hodnoty z formulara musia byt z povolenych moznosti v properties subore
	private void validateOptions(Employee employee, BindingResult bindingResult) {
		if (employee.getJobTitle() != null && !employee.getJobTitle().isBlank()
				&& !jobTitles.contains(employee.getJobTitle())) {
			bindingResult.rejectValue("jobTitle", "invalid", "Neplatná pracovná pozícia");
		}
		if (employee.getFullTime() != null && !employmentTypes.containsKey(employee.getFullTime())) {
			bindingResult.rejectValue("fullTime", "invalid", "Neplatný typ úväzku");
		}
	}
}
