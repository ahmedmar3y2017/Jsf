package com.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class studentTwo {
	private String firstName;
	private String lastName;
	
	private List<String> countryOptions;
	private String country;

	
	private List<String> languageOption;
	private String language;
	
	private String[] listLang;
	
	
	
	
	public studentTwo() {
	
		//   init values into form jsf page 
//		firstName="ahmed";
//		lastName="mar3y";
		
		
		// country 
		this.countryOptions=new ArrayList<>();
		countryOptions.add("Egypt");
		countryOptions.add("usa");
		countryOptions.add("auc");
		countryOptions.add("tanta");
		countryOptions.add("shebin");
		
		// language 
		languageOption=new ArrayList<>();
		languageOption.add("php");
		languageOption.add("paython");
		languageOption.add("java");
		languageOption.add("ruby");
		languageOption.add("js");

		
	}
	
	

	public String[] getListLang() {
		return listLang;
	}



	public void setListLang(String[] listLang) {
		this.listLang = listLang;
	}



	public List<String> getLanguageOption() {
		return languageOption;
	}



	public void setLanguageOption(List<String> languageOption) {
		this.languageOption = languageOption;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	public List<String> getCountryOptions() {
		return countryOptions;
	}



	public void setCountryOptions(List<String> countryOptions) {
		this.countryOptions = countryOptions;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
}
