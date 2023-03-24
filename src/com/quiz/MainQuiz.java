package com.quiz;

import java.util.Scanner;

import com.student.Student;

public class MainQuiz 
{
	Student student = new Student();
	Scanner scanner = new Scanner(System.in);
	RetrieveStudentResults retrieveS = new RetrieveStudentResults();
	
	
	public void enterChoice()
	{
		System.out.println();
		System.out.println("#########################################");
		System.out.println("1: Play Quizz Game");
		System.out.println("2: View All Results of Participants");
		System.out.println("3: View Result by Your Id");
		System.out.println("4: Exit Game");
		System.out.println("#########################################");
		System.out.println();
		System.out.println("Enter Your Choice: ");
		int choice =scanner.nextInt();
		switch(choice) 
		{
		  case 1: 
		  {
			  student.addStudent();
		    break;
		  }
		  case 2:
		  { 
			  retrieveS.dispStudentsSort();
		    break;
		  }
		  case 3:
		  {
			  retrieveS.getByID();
		    break;
		  }
		  case 4:
		  {
			System.out.println("Your Quizz Game is Exited");
		    break;
		  }
		  default:
		  {
		   System.out.println("Please...Enter valid choice number");
		   
		  }
		}
	}
	public static void main(String args[])
	{
				
		MainQuiz mainobj = new MainQuiz();		
		mainobj.enterChoice();
	}

}
