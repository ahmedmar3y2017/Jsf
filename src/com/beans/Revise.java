package com.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

@ManagedBean(name="revise")
@SessionScoped
public class Revise {
	
	private String text;
	
	private String outputText;
	private String pagrNumber;
	
	private String password;
	private boolean boolcheck;
	List<String> items ; 
	List<String> values ; 

	private Part file;
	
	
	public void UploadFile() {
		
		try {
			InputStream inputStream=file.getInputStream();
			File f=new File("D:\\upload\\image.jpg");
			if(!f.exists()) {
				
				
				f.createNewFile();
			}
			FileOutputStream fileOutputStream=new FileOutputStream(f);
			byte [] buffer=new byte[1024];
			
			int length;
			while((length=inputStream.read(buffer) )>0) {
				fileOutputStream.write(buffer, 0, length);
			
			}
			inputStream.close();
			fileOutputStream.close();
			
		}catch(Exception exception) {
			
			exception.printStackTrace();
			
		}
	}
	
	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}
	@PostConstruct
	public void init() {
		items=new ArrayList<>();
		items.add("php");
		items.add("java");
		items.add("c#");
		
		
		values=new ArrayList<>();
		
		
	}
	public void showArray() {
		
		System.out.println(values);
	}
	
	public List<String> getItems() {
		return items;
	}


	public void setItems(List<String> items) {
		this.items = items;
	}


	public List<String> getValues() {
		return values;
	}


	public void setValues(List<String> values) {
		this.values = values;
	}


	public void printBoolean () {
		
		System.out.println(boolcheck);
		
	}
	
	public boolean isBoolcheck() {
		return boolcheck;
	}

	public void setBoolcheck(boolean boolcheck) {
		this.boolcheck = boolcheck;
	}

	public void showPassword() {
		
		System.out.println("Password is : "+password);
		
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String forward() {
		
		if(pagrNumber.equalsIgnoreCase("2")) {
			return "second.xhtml?faces-redirect=true";
			
		}else 
		{
			return "third.xhtml?faces-redirect=true";

		}
		
	}
	
	public String getPagrNumber() {
		return pagrNumber;
	}





	public void setPagrNumber(String pagrNumber) {
		this.pagrNumber = pagrNumber;
	}





	public String getOutputText() {
		return outputText;
	}





	public void setOutputText(String outputText) {
		this.outputText = outputText;
	}





	public String getText() {
		return text;
	}





	public void setText(String text) {
		this.text = text;
	}





	public Revise() {
		text="ahmed mar2y";
	}


public void Click() {
	this.outputText="Hello : "+text;
	System.out.println(" Text is : "+text);
	
}


	public void OnClick() {
		
		System.out.println("Done ya man ");
		
	}

}
