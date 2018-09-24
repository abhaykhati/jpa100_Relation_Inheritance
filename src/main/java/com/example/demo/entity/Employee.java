package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//@Entity
@MappedSuperclass
 /*  MappedSuperclass:
  * An entity cannot be annotated with both @Entity and @MappedSuperclass at the same time
  * so disable @entity annotation and getAllEmployees() of EmployeeRepository
  * since it looks for an entity called Employee.
  * in order to run this application we have created separate  methods to get 
  * FullTimeEmployee and PartTimeEmployee
  * NO DATABASE CHANGES NEEDED.
  * As a result it creates 
  * PART_TIME_EMPLOYEE table with id, name and hourlyWage columns
  * Full_Time_Employee table with id, name and Salary columns
  * employee table is not created
  * 
  */

/*	@Inheritance(strategy=InheritanceType.JOINED)  
*  Important Note:
*   in order to use inheritance relationship you need to choose based on following points
*   in case of SINGLE_TABLE : if you are looking for performance then go for it as it consist only one table with multiple columns
*   =================================================================================================================================
*   in case of JOINED : Use it if you are more concerned about data integrity
*   
*   rest 2 strategies are not having performance behind it 
*
 * JOINED: 
 * A strategy in which fields that are specific to a
 * subclass are mapped to a separate table than the fields
 * that are common to the parent class, and a join is
 * performed to instantiate the subclass.
 * 
 * it will create 
 * Employee table with id and name column
 * PartTimeEmployee with id and HourlyWage
 * FullTimeEmployee with id and Salary
 * 
 */
	
/*	@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
 *  TABLE_PER_CLASS:
      will create concrete subclasses table for PartTimeEmployee and FullTimeEmployee
     disadvantage of this strtegy is we have multiple repeated columns in both tables, which is not performance boost for database
*/

/*	@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//default strategy : only single table named as Employee created
	@DiscriminatorColumn(name="Employee_Type")// to change DTYPE COLUMN NAME IN EMPLOYEE TABLE
 */
public abstract class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	public Employee() {
		
	}
	public Employee(String name) {
		this.name=name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=   " + id + ", name=   " + name + "]";
	}
	
	
}
