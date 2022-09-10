package com.lti.Maven_Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.lti.dao.DB_conn;
import com.lti.dao.Employee_Dao;
import com.lti.entity.Employee;

public class EmployeeDao_Test 
{
	public static Employee_Dao  dao;
	@BeforeAll
    static void init() throws SQLException {
        Connection conn = DB_conn.getConn();
        try {
            // set auto commit false so any operation in this test will be discarded.
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //emp_dao = new Employee_Dao(conn);
    }
     
    @AfterAll
    static void teardown() throws SQLException {
        Connection conn = DB_conn.getConn();
        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    void getConnectionTest()
    {
    	Connection conn=DB_conn.getConn();
    	assertNotNull(conn,"Connection established");
    }
    
    @Test
    public void addEmptest()
    {
    	Employee e=new Employee("emp2","emppass2","emp2@lti.com");
    	//Employee_Dao dao=new Employee_Dao();
    	dao.addEmp(e);
    	Employee empfromdb=dao.getEmpByUsername("emp2");
    	assertEquals(empfromdb.getPassword(), "emppass2","password check successfull");
    }
    
    @Test
    public void delEmp()
    {
    	//Employee_Dao dao=new Employee_Dao();
    	Employee e=dao.getEmpByUsername("emp22");
    	dao.deleteEmp("emp22");
    	assertNull(e.getUsername());
    }
    
    @BeforeAll
    public static void getDao()
    {
    	 dao=new Employee_Dao();
    	 
    }
}
