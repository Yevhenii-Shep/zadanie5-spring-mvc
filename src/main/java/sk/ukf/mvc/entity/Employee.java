package sk.ukf.mvc.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@NotBlank(message = "Meno je povinné")
	@Size(max = 255)
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "Priezvisko je povinné")
	@Size(max = 255)
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message = "Dátum narodenia je povinný")
	@Past(message = "Dátum narodenia musí byť v minulosti")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "birth_date")
	private LocalDate birthDate;

	@NotBlank(message = "Email je povinný")
	@Email(message = "Zadajte platný email")
	@Size(max = 255)
	@Column(name = "email")
	private String email;

	@NotBlank(message = "Telefón je povinný")
	@Pattern(regexp = "^\\+?[0-9 ]{6,14}$", message = "Telefón môže obsahovať len číslice, medzery a + na začiatku (max. 15 znakov)")
	@Column(name = "phone")
	private String phone;

	@NotBlank(message = "Vyberte pracovnú pozíciu")
	@Column(name = "job_title")
	private String jobTitle;

	@PositiveOrZero(message = "Plat nemôže byť záporný")
	@Digits(integer = 10, fraction = 0, message = "Plat zadajte ako celé číslo")
	@Column(name = "salary")
	private BigDecimal salary;

	@NotNull(message = "Vyberte typ úväzku")
	@Column(name = "full_time")
	private Integer fullTime;

	public Employee() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Integer getFullTime() {
		return fullTime;
	}

	public void setFullTime(Integer fullTime) {
		this.fullTime = fullTime;
	}

	public String getInitials() {
		String first = firstName == null || firstName.isBlank() ? "" : firstName.substring(0, 1);
		String last = lastName == null || lastName.isBlank() ? "" : lastName.substring(0, 1);
		return (first + last).toUpperCase();
	}
}
