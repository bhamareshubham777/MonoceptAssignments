package crudusingjdbc;

public class Department {

	private int deptNo;
	private String dName;
	private String location;
	
	public Department(int deptNo, String dName, String location) {
		super();
		this.deptNo = deptNo;
		this.dName = dName;
		this.location = location;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
