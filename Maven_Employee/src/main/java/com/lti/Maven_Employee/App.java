package com.lti.Maven_Employee;

import java.util.Scanner;

import com.lti.dao.Employee_Dao;
import com.lti.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Employee_Dao obj=new Employee_Dao();
        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter employee details");
//        Employee e=new Employee();
//        e.setUsername(sc.nextLine());
//        e.setPassword(sc.nextLine());
//        e.setEmail(sc.nextLine());
//        obj.addEmp(e);
//        Employee e1=obj.getEmpByUsername(e.getUsername());
//        System.out.println(e1);
        obj.deleteEmp("emp2");
        sc.close();
    }
}
