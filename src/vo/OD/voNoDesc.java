package vo.OD;
/*得到业务字典、基本数据表的编码和相应描述*/
public class voNoDesc {
	private String voNo;
	private String voDesc;
	private int ifVoid;
	private String foreignKey;
	public String getVoNo() {
		return voNo;
	}
	public void setVoNo(String voNo) {
		this.voNo = voNo;
	}
	public String getVoDesc() {
		return voDesc;
	}
	public void setVoDesc(String voDesc) {
		this.voDesc = voDesc;
	}
	public int getIfVoid() {
		return ifVoid;
	}
	public void setIfVoid(int ifVoid) {
		this.ifVoid = ifVoid;
	}
	public String getForeignKey() {
		return foreignKey;
	}
	public void setForeignKey(String foreignKey) {
		this.foreignKey = foreignKey;
	}
	
	
}
