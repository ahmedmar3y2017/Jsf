package Beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "calc")
@SessionScoped
public class calcController {

	private String display;

	private int temp;
	private String operation;

	@PostConstruct
	public void init() {
		// display = "ahmed";

	}

	public void addOperation(String oper) {
		temp = Integer.parseInt(display);
		this.operation = oper;
		display = "";

	}

	public void calc() {
		int value = Integer.parseInt(display);
		if (operation.equalsIgnoreCase("+")) {
			display = "" + (temp + value);
		} else if (operation.equalsIgnoreCase("-")) {
			display = "" + (temp - value);
		} else if (operation.equalsIgnoreCase("*")) {
			display = "" + (temp * value);
		} else if (operation.equalsIgnoreCase("/")) {
			display = "" + (temp / value);
		}

	}

	public void clear() {
		display = display.substring(0, display.length() - 1);

	}

	public void show(String digit) {
		display += digit;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

}
