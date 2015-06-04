package vo.BD;

import java.sql.Date;

public class voBDship {
	public String shipNo;
	public String contractNo;
	public Date ruturndate;
	public String shipState;
	public String getShipNo() {
		return shipNo;
	}
	public void setShipNo(String shipNo) {
		this.shipNo = shipNo;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Date getRuturndate() {
		return ruturndate;
	}
	public void setRuturndate(Date ruturndate) {
		this.ruturndate = ruturndate;
	}
	public String getShipState() {
		return shipState;
	}
	public void setShipState(String shipState) {
		this.shipState = shipState;
	}
	
}
