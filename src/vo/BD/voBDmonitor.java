package vo.BD;

import java.sql.Date;

public class voBDmonitor {
	public String monitorNo;
	public String contractNo;
	public String employeeNo;
	public Date monitordate;
	public String getMonitorNo() {
		return monitorNo;
	}
	public void setMonitorNo(String monitorNo) {
		this.monitorNo = monitorNo;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public Date getMonitordate() {
		return monitordate;
	}
	public void setMonitordate(Date monitordate) {
		this.monitordate = monitordate;
	}
	
}
