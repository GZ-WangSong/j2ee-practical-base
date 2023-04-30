package cn.edu.njust.pojo;

public class HitCourse {
	private int uId;
	private String uName;
	private String cId;
	private String cName;
	private double score;
	
	public HitCourse(){}
	
	public HitCourse(int uId, String uName, String cId, String cName,
			double score) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.cId = cId;
		this.cName = cName;
		this.score = score;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getName() {
		return uName;
	}

	public void setName(String name) {
		this.uName = name;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	
}
