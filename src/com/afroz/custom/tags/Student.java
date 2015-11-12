package com.afroz.custom.tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.StringTokenizer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Student extends SimpleTagSupport {
	private String firstName;
	private int age;
	private double height;
	private StringWriter sw = new StringWriter();

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		// read tag body content into string writer object.
		getJspBody().invoke(sw);
		StringTokenizer st = new StringTokenizer(sw.toString(), " ");
		firstName = st.nextToken();
		age = Integer.parseInt(st.nextToken().trim());
		height = Double.parseDouble(st.nextToken().trim());
		getJspContext().getOut()
				.print("Student: " + firstName + " age: " + age + " height: "
						+ height);
		System.out.println("Student: " + firstName + " age: " + age
				+ " height: " + height);
	}
}
