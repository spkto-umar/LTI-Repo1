package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.entity.Employee;

public class Employee_Dao 
{
	private Connection con;

	public Employee_Dao() {
		this.con = DB_conn.getConn();
	}
	
	public void addEmp(Employee e)
	{
		try {
			String insert="insert into employee_table values(?,?,?)";
			PreparedStatement pt=con.prepareStatement(insert);
			pt.setString(1,e.getUsername());
			pt.setString(2,e.getPassword());
			pt.setString(3,e.getEmail());
			pt.executeUpdate();
			pt.close();
			System.out.println("Row inserted");
		} catch (SQLException e1) {
			System.out.println("Prepared Statement not executed");
			//e1.printStackTrace();
		}
	}

	public Employee getEmpByUsername(String un) {
		String getByUn="select * from employee_table where username=?";
		PreparedStatement pt=null;
		ResultSet rs=null;
		Employee emp=new Employee();
		try {
			pt = con.prepareStatement(getByUn);
			pt.setString(1, un);
			rs=pt.executeQuery();
			while(rs.next())
			{
			emp=new Employee(rs.getString(1),rs.getString(2),rs.getString(3));
			}
			pt.close();rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
	public void deleteEmp(String un)
	{
		String delByUn="delete from employee_table where username=?";
		PreparedStatement pt=null;
		try {
			pt = con.prepareStatement(delByUn);
			pt.setString(1, un);
			//System.out.println(pt);
			pt.executeUpdate();
			pt.close();
			System.out.println(un+ " Employee details deleted");
		}catch(SQLException s)
		{
			s.printStackTrace();
			System.out.println("Not Deleted");
		}
	}
}
