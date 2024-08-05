package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	private DataSource dataSource;
	
	public StudentDbUtil (DataSource dataSource)
	{
		this.dataSource =dataSource;
	}
	public  List<Student> getStudents() throws SQLException{
		List <Student> students =new ArrayList<>();
	     Connection con =null;
	     Statement stmt = null;
	     ResultSet rslt = null;
	    
	     try {
	    	 
	    	 con=dataSource.getConnection();
	    	 String sql =" select * from student order by last_name";
	    	 stmt =con.createStatement();
	    	 rslt=stmt.executeQuery(sql);
	    	 while (rslt.next()) {
	    		 int id=rslt.getInt("id");
	    		 String firstName= rslt.getString("first_name");
	    		 String lastName= rslt.getString("last_name");
	    		 String email = rslt.getString("email");
	    		 Student tempStudent = new Student(id , firstName ,lastName,email);
	    		 students.add(tempStudent);
	    		 
	    	 }
	    	  return students;
	 	}
	     finally{
	    	 //close jdbc
	    	 close(con,stmt,rslt);
	    	 
	     }
	}
	private void close(Connection con, Statement stmt, ResultSet rslt) {
		// TODO Auto-generated method stub
		try {
	if(rslt !=null) {
		rslt.close();
	}
	if(stmt != null )
	{
		stmt.close();
	}
	if(con !=null) {
		con.close();
	}
	
	}
		catch(Exception ex){
			ex.printStackTrace();
		}
	
	}
	public void addStudent(Student student) throws SQLException {
	Connection con =null;
	PreparedStatement stmt=null;
	try {
		con=dataSource.getConnection();
		String sql ="insert into student (first_name,last_name,email) values (?,?,?)";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, student.getFirstName());
		stmt.setString(2, student.getLastName());
		stmt.setString(3, student.getEmail());
		stmt.execute();
	}
	finally{
		close(con,stmt,null);
		
	}
	
	
	}
	public Student getStudents(String studentId) {
	Student student =null;
	Connection con=null;
	PreparedStatement stmt = null;
	ResultSet rslt=null;
	
	try {
		
		
		
	return student;	
	}
	finally {
		
	}
	}
	
}