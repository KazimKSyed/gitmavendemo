package com.hbm.practice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Student_Info")

public class StudentEntity {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Student_id")
	private int studentId;

	@Column(name = "Student_Name",nullable=false)
	private String StudentName;

	@Column(name = "Email",unique=true)
	private String email;

	@Column(name = "Date_Of_Joining")
	private Date doj;
	
	
	
	@OneToMany(mappedBy="st",fetch=FetchType.LAZY ,cascade=CascadeType.ALL)
   // @JoinColumn(name="aid", referencedColumnName="Student_id")
	private List<Address> add;
	
	public List<Address> getAdd() {
		return add;
	}

	public void setAdd(List<Address> add) {
		this.add = add;
	}


	
	
	
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}


	public StudentEntity(int studentId, String studentName, String email, Date doj, List<Address> add) {
		super();
		this.studentId = studentId;
		StudentName = studentName;
		this.email = email;
		this.doj = doj;
		this.add = add;
	}

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", StudentName=" + StudentName + ", email=" + email + ", doj="
				+ doj + ", add=" + add + "]";
	}

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
