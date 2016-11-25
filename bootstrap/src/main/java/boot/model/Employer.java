package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="employees")
public class Employer implements Serializable {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="emp_no")
    private int empNo;
    @Column(name="birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name="first_name",length=14)
    private String firstName;
    @Column(name="last_name",length=16)
    private String lastName;
    private boolean gender;
    @Column(name="hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    
    
    
	public Employer() {
		this(0,new Date(),"","",false,new Date());
	}
	











	public Employer(int empNo, Date birthDate, String firstName, String lastName, boolean gender, Date hireDate) {
		super();
		this.empNo = empNo;
		this.birthDate = birthDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.hireDate = hireDate;
	}












	public int getEmpNo() {
		return empNo;
	}












	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}












	public Date getBirthDate() {
		return birthDate;
	}












	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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












	public boolean isGender() {
		return gender;
	}












	public void setGender(boolean gender) {
		this.gender = gender;
	}












	public Date getHireDate() {
		return hireDate;
	}












	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}












	@Override
	public String toString() {
		return "Employer [empNo=" + empNo + ", birthDate=" + birthDate + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", hireDate=" + hireDate + "]";
	}












	
    
	
	
	
}
