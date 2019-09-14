package com.yogi.jogi.map.model;

import java.util.Date;

public class CourseModel {

	private int coursenum;
	private String subject;
	private Date cdate;
	private String starting;
	private String destination;
	private String course1;
	private String course2;
	private String course3;
	private String course4;
	private String course5;
	private String course6;
	
	public int getCoursenum() {
		return coursenum;
	}
	public void setCoursenum(int coursenum) {
		this.coursenum = coursenum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String getStarting() {
		return starting;
	}
	public void setStarting(String starting) {
		this.starting = starting;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCourse1() {
		return course1;
	}
	public void setCourse1(String course1) {
		this.course1 = course1;
	}
	public String getCourse2() {
		return course2;
	}
	public void setCourse2(String course2) {
		this.course2 = course2;
	}
	public String getCourse3() {
		return course3;
	}
	public void setCourse3(String course3) {
		this.course3 = course3;
	}
	public String getCourse4() {
		return course4;
	}
	public void setCourse4(String course4) {
		this.course4 = course4;
	}
	public String getCourse5() {
		return course5;
	}
	public void setCourse5(String course5) {
		this.course5 = course5;
	}
	public String getCourse6() {
		return course6;
	}
	public void setCourse6(String course6) {
		this.course6 = course6;
	}
	@Override
	public String toString() {
		return "CourseModel [coursenum=" + coursenum + ", subject=" + subject + ", cdate=" + cdate + ", starting="
				+ starting + ", destination=" + destination + ", course1=" + course1 + ", course2=" + course2
				+ ", course3=" + course3 + ", course4=" + course4 + ", course5=" + course5 + ", course6=" + course6
				+ "]";
	}
	
	
}
