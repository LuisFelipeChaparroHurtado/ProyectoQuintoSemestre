/* Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.*/
package co.edu.usta.tunja.supermarket;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import co.edu.usta.tunja.supermarket.model.*;
import co.edu.usta.tunja.supermarket.persistence.entity.ProductTypeEntity;

/**
 * Maven archetype for generating a JPA application.
 * The sample connects to Oracle Database and does some database operations.
 * Make sure to use the schema (JDBCSampleData.sql) at https://tinyurl.com/y2a7x65z
 * to create the tables "emp" and "dept" required for this sample. 
 * @author Nirmala Sundarappa
 */
public class App {
	public static void main(String[] args) {
            
            EntityManagerFactory emf= null;
            EntityManager entityManager = null;
            EntityTransaction transaction= null;
            try {
                emf = Persistence.createEntityManagerFactory("supermarket_PU");
                entityManager = emf.createEntityManager();
                transaction = entityManager.getTransaction();
                transaction.begin();
                ProductTypeEntity pte = new ProductTypeEntity();
                pte.setProduct_type_name("Aromatizadores");
                entityManager.persist(pte);
                transaction.commit();
                
                /*
                Student student = new Student();
                student.setFirstName("Jhon");
                student.setLastName("Bloch");
                student.setContactNo("+1-408-575-1317");
                entityManager.persist(pte);
                transaction.commit();
                Query q = entityManager.createQueary("select s from Stu s");
                List<Student> resultList = q.getResultList();
                System.out.println("num of students: "+resultList.size());
                for(Student next : resultList){
                    System.out.println("next student: "+next);
                }
                */
                
            } catch (Exception e) {
            }
            /*
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("supermarket_PU");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		TypedQuery<Emp> empQuery = manager.createNamedQuery("Emp.findAll", Emp.class);
		List<Emp> emps = empQuery.getResultList();
		System.out.println(String.format("%6s   %15s  %15s","EMPNO", "ENAME", "JOB"));
		System.out.println(String.format("%6s   %15s  %15s","------", "-----------", "-----------"));
		for (Emp emp : emps) {
			System.out.println(String.format("%6s   %15s  %15s",emp.getEmpno(), emp.getEname(), emp.getJob()));
		}

		System.out.println("\nPrinting the list of Managers:");
		empQuery = manager.createNamedQuery("Emp.findByJob", Emp.class).setParameter("job", "MANAGER");
		emps = empQuery.getResultList();
		System.out.println(String.format("%6s   %15s  %15s","EMPNO", "ENAME", "JOB"));
		System.out.println(String.format("%6s   %15s  %15s","------", "-----------", "-----------"));
		for (Emp emp : emps) {
			System.out.println(String.format("%6s   %15s  %15s",emp.getEmpno(), emp.getEname(), emp.getJob()));
		}

		System.out.println("\nPrinting the list of Departments:");
		TypedQuery<Dept> deptQuery = manager.createNamedQuery("Dept.findAll", Dept.class);
		List<Dept> depts = deptQuery.getResultList();
		System.out.println(String.format("%6s   %15s  %15s","DEPTNO", "DNAME", "LOC"));
		System.out.println(String.format("%6s   %15s  %15s","------", "-----------", "-----------"));

		for (Dept dept : depts) {
			System.out.println(String.format("%6s   %15s  %15s", dept.getDeptno(), dept.getDname(), dept.getLoc()));
		}
		
		
		System.out.println("\nPrinting the list of Employees in ACCONTING dept:");
		empQuery = manager.createNamedQuery("Dept.findEmpByDept", Emp.class)
				.setParameter("dname", "ACCOUNTING");
		emps = empQuery.getResultList();
		System.out.println(String.format("%6s   %15s  %15s","EMPNO", "ENAME", "JOB"));
		System.out.println(String.format("%6s   %15s  %15s","------", "-----------", "-----------"));
		for (Emp emp : emps) {
			System.out.println(String.format("%6s   %15s  %15s", emp.getEmpno(), emp.getEname(), emp.getJob()));
		}
		// we did not do anything so rollback
		// Commit if you have any DML operations
		tx.rollback();

		System.out.println(".. done");*/

	}
}
