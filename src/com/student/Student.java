package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.connection.quiz.ConnectionProvider;
import com.quiz.Quiz;

public class Student implements studentInterface {
	int id;
	String name;
	int score=0;
	Scanner sc = new Scanner(System.in);
	ConnectionProvider obj1= new ConnectionProvider();
	Connection con1;

	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getScore() 
	{
		return score;
	}
	public void setScore(int score) 
	{
		this.score = score;
	}
	
	
	public void addStudent()
	{
		System.out.println("Enter Your Unique Id: ");
		int tempid =sc.nextInt();
		setId(tempid);
		
		System.out.println("Enter Your Name: ");
		String tempnm =sc.next();
		setName(tempnm);
		try
		{
			
		    con1=obj1.getCon();
			PreparedStatement pt = con1.prepareStatement("insert into student(id,name)values(?,?)");
			
			pt.setInt(1, getId());
			pt.setString(2, getName());
			pt.executeUpdate();
			System.out.println("======================================================");	
			System.out.println("***** Student Registration Successfully ***** ");
			System.out.println("*** Starting Quiz *** ");
			System.out.println("======================================================");	
			
			Quiz q = new Quiz();
			q.getRandQue(tempid);
		}
		catch(Exception e)
		{
			try {
				con1=obj1.getCon();
				PreparedStatement pst = con1.prepareStatement("Select id from student");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					if(tempid==rs.getInt(1))
					{
						System.out.println("Please enter different id for Student ");
						addStudent();
					}
				}
				
			}catch(Exception duplicate_id)
			{
				System.out.println(duplicate_id);
			}
			System.out.println(e);
		}	
	}

}
