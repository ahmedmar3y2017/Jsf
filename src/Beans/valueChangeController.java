package Beans;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "valueController")
@SessionScoped
public class valueChangeController {

	private Map<String, String> countries;
	private Map<String, String> cities;

	@PostConstruct
	public void init() {
		countries = new HashMap<>();
		cities = new HashMap<>();
		countries.put("egypt", "egypt");
		countries.put("usa", "usa");

	}

	public void valueChange(ValueChangeEvent valueChangeEvent) {
		System.out.println("Old : " + valueChangeEvent.getOldValue());
		System.out.println("New : " + valueChangeEvent.getNewValue());
		if (valueChangeEvent.getNewValue().equals("egypt")) {
			cities.clear();
			cities.put("cairo", "cairo");
			cities.put("tabta", "tabta");


		} else if (valueChangeEvent.getNewValue().equals("usa")) {
			cities.clear();
			cities.put("aaa", "aaa");
			cities.put("bbb", "bbb");

		}

	}

	public Map<String, String> getCountries() {
		return countries;
	}

	public void setCountries(Map<String, String> countries) {
		this.countries = countries;
	}

	public Map<String, String> getCities() {
		return cities;
	}

	public void setCities(Map<String, String> cities) {
		this.cities = cities;
	}

}
