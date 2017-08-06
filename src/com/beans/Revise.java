package com.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

@ManagedBean(name = "revise")
@SessionScoped
public class Revise {

	private String text;

	private String outputText;
	private String pagrNumber;

	private String password;
	private boolean boolcheck;
	List<String> items;
	List<String> values;
	private String time;
	private String inputmessage;
	private Part file;

	public void messageAction() {
		FacesContext fc = FacesContext.getCurrentInstance();

		if (inputmessage.equals("1")) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Info Message ... ", "Detail ..."));
		} else if (inputmessage.equals("2")) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"WARN Message ... ", "Detail ..."));
		} else if (inputmessage.equals("3")) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"FATAL Message ... ", "Detail ..."));
		} else if (inputmessage.equals("4")) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"ERROR Message ... ", "Detail ..."));
		}

	}

	public String getInputmessage() {
		return inputmessage;
	}

	public void setInputmessage(String inputmessage) {
		this.inputmessage = inputmessage;
	}

	// *************** show Time ********
	public void showTime() {

		Date d = new Date();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
		time = simpleDateFormat.format(d);

	}

	// ****** ajax function ******
	public void clickAjax() {

		System.out.println("Ajax Functions ....");

	}

	public void changeAjax() {

		System.out.println("changeAjax Functions ....");

	}

	// downoad file
	public void download() throws IOException {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();

		ec.responseReset(); // Some JSF component library or some Filter might
							// have set some headers in the buffer beforehand.
							// We want to get rid of them, else it may collide.
		ec.setResponseContentType("image/jpg"); // Check
												// http://www.iana.org/assignments/media-types
												// for all types. Use if
												// necessary
												// ExternalContext#getMimeType()
												// for auto-detection based on
												// filename.
												// ec.setResponseContentLength(contentLength);
												// // Set it with the file
		// size. This header is
		// optional. It will work if
		// it's omitted, but the
		// download progress will be
		// unknown.
		ec.setResponseHeader("Content-Disposition", "attachment; filename=\""
				+ "\"image.jpg\""); // The Save As popup magic is done here. You
									// can give it any file name you want, this
									// only won't work in MSIE, it will use
									// current request URL as file name instead.
		FileInputStream fileInputStream = new FileInputStream(new File(
				"D:\\upload\\image.jpg"));
		OutputStream output = ec.getResponseOutputStream();
		// Now you can write the InputStream of the file to the above
		// OutputStream the usual way.
		// ...
		byte[] buffer = new byte[1024];

		int length;
		while ((length = fileInputStream.read(buffer)) > 0) {
			output.write(buffer, 0, length);

		}
		fileInputStream.close();
		fc.responseComplete(); // Important! Otherwise JSF will attempt to
								// render the response which obviously will fail
								// since it's already written with a file and
								// closed.
	}

	// ****** upload file ******
	public void UploadFile() {

		try {
			InputStream inputStream = file.getInputStream();
			File f = new File("D:\\upload\\image.jpg");
			if (!f.exists()) {

				f.createNewFile();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(f);
			byte[] buffer = new byte[1024];

			int length;
			while ((length = inputStream.read(buffer)) > 0) {
				fileOutputStream.write(buffer, 0, length);

			}
			inputStream.close();
			fileOutputStream.close();

		} catch (Exception exception) {

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
		items = new ArrayList<>();
		items.add("php");
		items.add("java");
		items.add("c#");

		values = new ArrayList<>();

	}

	public void showArray() {

		System.out.println(values);
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public void printBoolean() {

		System.out.println(boolcheck);

	}

	public boolean isBoolcheck() {
		return boolcheck;
	}

	public void setBoolcheck(boolean boolcheck) {
		this.boolcheck = boolcheck;
	}

	public void showPassword() {

		System.out.println("Password is : " + password);

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String forward() {

		if (pagrNumber.equalsIgnoreCase("2")) {
			return "second.xhtml?faces-redirect=true";

		} else {
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
		text = "ahmed mar2y";
	}

	public void Click() {
		this.outputText = "Hello : " + text;
		System.out.println(" Text is : " + text);

	}

	public void OnClick() {

		System.out.println("Done ya man ");

	}

}
