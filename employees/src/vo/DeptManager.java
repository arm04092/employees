package vo;

public class DeptManager {
	private Employees employees;
	private Departments departments;
	private String fromDate;
	private String toDate;
	public Employees getEmployees() {
		return employees;
	}
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	public Departments getDepartments() {
		return departments;
	}
	public void setDepartments(Departments departments) {
		this.departments = departments;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	@Override
	public String toString() {
		return "DeptManager [employees=" + employees + ", departments=" + departments + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + "]";
	}
	
	
}
