package vo.BD;

import java.sql.Date;

public class voBDcontract {
	public String contractNo;
	public String customerNo;
	public String employeeNo;
	public double ordersum;
	public Date signdate;
	public String paymentway;
	public String refunds;
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public double getOrdersum() {
		return ordersum;
	}
	public void setOrdersum(double ordersum) {
		this.ordersum = ordersum;
	}
	public Date getSigndate() {
		return signdate;
	}
	public void setSigndate(Date signdate) {
		this.signdate = signdate;
	}
	public String getPaymentway() {
		return paymentway;
	}
	public void setPaymentway(String paymentway) {
		this.paymentway = paymentway;
	}
	public String getRefunds() {
		return refunds;
	}
	public void setRefunds(String refunds) {
		this.refunds = refunds;
	}
	
}
