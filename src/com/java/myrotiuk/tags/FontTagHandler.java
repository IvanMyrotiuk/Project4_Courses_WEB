package com.java.myrotiuk.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class FontTagHandler extends TagSupport {

	String size = "10";
	String color = "gold";
	
	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		
		try {
			out.println("<center><font size ='"+size+"' color = '"+color+"'>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return TagSupport.EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		
		try {
			out.print("</font></center><br/>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return TagSupport.EVAL_PAGE;
	}
	
	public void setSize(String size){
		this.size = size;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
}
