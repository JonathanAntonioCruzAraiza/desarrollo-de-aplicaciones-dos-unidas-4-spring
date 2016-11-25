package boot.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="student")
public class Student implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private int studentId;
	@Column(length=45)
	private String firstname;
	@Column(length=45)
	private String lastname;
	@Column(name="year_level",length=10)
	private int yearLevel;
	
	public Student(){
		this(0,"","",0);
	}
	

	public Student(int studentId,String firstname,String lastname,int yerarLevel){
		super();
		this.studentId=studentId;
		this.firstname=firstname;
		this.lastname=lastname;
		this.yearLevel=yerarLevel;
	}





	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public int getYearLevel() {
		return yearLevel;
	}


	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", yearLevel=" + yearLevel + "]";
	}


	
	 
	

}
