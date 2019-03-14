	package com.hbm.consumeRestservice;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestConsumeTest {

	private static String SERVICE_BASE_URI="http://localhost:8090/springMVCjava1/api/student/";
	
	static JSONObject requestParam=new JSONObject();
	static {
		requestParam.put("studentId", 9);
		requestParam.put("studentName", "kazim");
		requestParam.put("standard", "tenth");
		requestParam.put("board", "icse");
		System.out.println("change from local");
		

	}
	
	public static void main(String[] args) {
		List<StudentBean> students=getAllStudents();
		System.out.println("here are deseriazed emps ........" +students);
		//getAllStudents();
		//getStudent();
		//createStudent();
		//modifyStudent();
		//deleteStudent();

			int j=20;


			
		
	}

	private static void deleteStudent(){
		RestAssured.baseURI=SERVICE_BASE_URI;
		Response response=RestAssured.given().contentType("application/json").body("").delete("4");

		System.out.println(response);
	}
	
	private static void modifyStudent() {
		RestAssured.baseURI=SERVICE_BASE_URI;
		Response response=RestAssured.given().contentType("application/json").body(requestParam.toString()).put("/");
		System.out.println(response);
	}
	private static void createStudent() {
		RestAssured.baseURI=SERVICE_BASE_URI;
		RequestSpecification request=RestAssured.given().contentType("application/json");
		System.out.println(requestParam.toString());
		request.body(requestParam.toString());
		Response response=request.post("/");
		System.out.println(response.statusCode());
		System.out.println(response);
	}
	private static void getStudent() {
		Response response=RestAssured.get(SERVICE_BASE_URI+"4");
		System.out.println(response.asString());
	}

	private static List<StudentBean> getAllStudents() {
		Response response = RestAssured.get(SERVICE_BASE_URI);
		JSONArray jsonArray=new JSONArray(response.asString());
		List<StudentBean> listOfStudent=new ArrayList<StudentBean>();
		for(int i=0;i<jsonArray.length();i++) {
			JSONObject obj=jsonArray.getJSONObject(i);
			listOfStudent.add(new StudentBean(obj.getInt("studentId"),obj.getString("studentName"),obj.getString("standard"),obj.getString("board")));
		}
		
		return listOfStudent;
	}

}

class StudentBean{
	private int studentId;
	private String studentName;
	private String standard;
	private String board;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	@Override
	public String toString() {
		return "\nStudentBean [studentId=" + studentId + ", studentName=" + studentName + ", standard=" + standard
				+ ", board=" + board + "]";
	}
	public StudentBean(int studentId, String studentName, String standard, String board) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.standard = standard;
		this.board = board;
	}
	
	public StudentBean() {
		super();
	}
}
