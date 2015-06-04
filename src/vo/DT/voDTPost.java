package vo.DT;

public class voDTPost {
	private String postNo;
	private String postName;
	private int ifVoid;
	private String foreignKey;
	public String getPostNo() {
		return postNo;
	}
	@Override
	public String toString() {
		return "voDTPost [postNo=" + postNo + ", postName=" + postName
				+ ", ifVoid=" + ifVoid + ", foreignKey=" + foreignKey + "]";
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
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
	public voDTPost(){}
	public voDTPost(String postNo, String postName) {
		super();
		this.postNo = postNo;
		this.postName = postName;
	}
	public voDTPost(String postNo, String postName, String foreignKey) {
		this(postNo,postName);
		this.foreignKey = foreignKey;
	}
	

}
