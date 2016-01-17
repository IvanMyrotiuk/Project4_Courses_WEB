package com.java.myrotiuk.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MultipleTextTagHandler extends BodyTagSupport {
	
	private int count = 7;
	private String body;
	private StringBuilder builder;
	
	@Override
	public int doStartTag() throws JspException {
		body = null;
		builder = new StringBuilder();
		builder.append("<center>");
		return BodyTagSupport.EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doAfterBody() throws JspException {
		
		BodyContent bc = this.getBodyContent(); 
		if(body == null){
			body = bc.getString();
		}
		
		if(count > 0){
			builder.append("<font size ="+count+">"+body+"</font><br/>");//"</h"+count+">");
			count--;
			return BodyTagSupport.EVAL_BODY_AGAIN;
		}else{
			builder.append("</center>");
			return BodyTagSupport.SKIP_BODY;
		}
	}
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		count = 7;
		
		try {
			//System.out.println(builder.toString());
			out.println(builder.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return BodyTagSupport.EVAL_PAGE;
	}
	
	public void setCount(Integer count){
		this.count = count;
	}
	
}
