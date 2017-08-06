package Beans;

public class Experience {

	private String comapny;
	private String position;

	
	
	public Experience() {
		super();
	}

	public Experience(String comapny, String position) {
		super();
		this.comapny = comapny;
		this.position = position;
	}

	public String getComapny() {
		return comapny;
	}

	public void setComapny(String comapny) {
		this.comapny = comapny;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
