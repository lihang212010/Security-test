package com.example.demo;

public class Msg {
private String title;
private String content;
private String etraInfo;
public Msg(String title,String content,String etraInfo) {
	super();
	this.title=title;
	this.content=content;
	this.etraInfo=etraInfo;
}
public void setTitle(String title) {
	this.title = title;
}
public String getTitle() {
	return title;
}
public void setContent(String content) {
	this.content = content;
}
public String getContent() {
	return content;
}
public void setEtraInfo(String etraInfo) {
	this.etraInfo = etraInfo;
}
public String getEtraInfo() {
	return etraInfo;
}
}
