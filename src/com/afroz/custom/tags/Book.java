package com.afroz.custom.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Book extends SimpleTagSupport {

	private String name;
	private int number;
	private double price;
	private String type;

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		if (name != null) {
			out.print("<ul type=\"" + type + "\">" + "<li>" + name
					+ "</li><ol type=1>" + "<li>" + number + "</li>" + "<li> $"
					+ price + "</li>" + "</ol>" + "" + "</ul>");
		}
	}
}
