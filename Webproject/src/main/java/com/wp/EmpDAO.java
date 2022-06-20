package com.wp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.wp.DbUtil;

public class EmpDAO {
	
	//create data
	public Employee createdata() {
		Employee e=new Employee();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the empid");
		e.setEid(sc.nextInt());
		System.out.println("enter the name");
		e.setEname(sc.next());
		System.out.println("enter the email");
		e.setEemail(sc.next());
		return e;
	}
	
	
	

	//insert into the table
	int insert(Employee e) throws ClassNotFoundException, SQLException {
		Connection con=DbUtil.dbconn();
		if(con!=null) {
			System.out.println("connection established in insert code");
		}
		else {
			System.out.println("check the connection");
		}
		
		//(101,'raj','rtas@gtyu.com')
		//Statement st=con.createStatement();
		//String sql="insert into employee values("+e.getEid()+",'"+e.getEname()+"','"+e.getEemail()+"')";
		String sql="insert into employee values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,e.getEid());
		ps.setString(2,e.getEname());
		ps.setString(3,e.getEemail());
		
		return ps.executeUpdate();
	}
	public ResultSet display() throws ClassNotFoundException, SQLException {
		Connection con=DbUtil.dbconn();
		if(con!=null) {
			System.out.println("connection established in display code");
		}
		else {
			System.out.println("check the connection");
		}
		
		//Statement st=con.createStatement();
		String sql="select * from employee";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		return rs;
//		while(rs.next()) {
//			System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"  "+rs.getString(3));
//		}
	}








//update
int update() throws ClassNotFoundException, SQLException {
		Connection con=DbUtil.dbconn();
		if(con!=null) {
			System.out.println("connection established in update code");
		}
		else {
			System.out.println("check the connection");
		}
		Employee e1=new Employee();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the empid");
		e1.setEid(sc.nextInt());
		System.out.println("enter the name");
		e1.setEname(sc.next());
		//(101,'raj','rtas@gtyu.com')
		//Statement st=con.createStatement();
		//String sql="insert into employee values("+e.getEid()+",'"+e.getEname()+"','"+e.getEemail()+"')";
		String sql="update employee set ename=? where eid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,e1.getEname());
		ps.setInt(2,e1.getEid());
		return ps.executeUpdate();
	}
}