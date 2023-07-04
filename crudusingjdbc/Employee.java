package crudusingjdbc;

import java.util.Date;

public class Employee {

	private int empNo;
	private String eName;
	private String JOB;
	private int MGR;
	private Date hiredate;
	private double salary;
	private double comm;
	private int deptNo;
	
	public Employee(int empNo, String eName, String jOB, int mGR, Date hiredate, double salary, double comm,
			int deptNo) {
		super();
		this.empNo = empNo;
		this.eName = eName;
		JOB = jOB;
		MGR = mGR;
		this.hiredate = hiredate;
		this.salary = salary;
		this.comm = comm;
		this.deptNo = deptNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getJOB() {
		return JOB;
	}

	public void setJOB(String jOB) {
		JOB = jOB;
	}

	public int getMGR() {
		return MGR;
	}

	public void setMGR(int mGR) {
		MGR = mGR;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getComm() {
		return comm;
	}

	public void setComm(double comm) {
		this.comm = comm;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	
}
