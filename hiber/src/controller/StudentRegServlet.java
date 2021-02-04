package controller;

import java.io.*;
import bean.student;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.hibernate.classic.Session;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/reg")
public class StudentRegServlet extends HttpServlet {
	SessionFactory sf;
	
	
	public void init(ServletConfig config)throws ServletException{
		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		sf=cfg.buildSessionFactory();
		//Transaction t=cfg.beginTransaction();
	}
       
    
    public StudentRegServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		//String email=request.getParameter("email");
		//int marks=Integer.parseInt(request.getParameter("marks"));
		
		//Student_Reg s=new Student_Reg(0,name,email,marks);
		student s=new student(0,name);
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		int pk=(Integer)session.save(s);
		
		t.commit();
		session.close();
		
	}

}
