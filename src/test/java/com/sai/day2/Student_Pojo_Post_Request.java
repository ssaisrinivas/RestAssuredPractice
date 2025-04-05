package com.sai.day2;

import java.util.Arrays;

public class Student_Pojo_Post_Request {
int id;
String name;
String location;
String phone;
String[] courses;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String[] getCourses() {
	return courses;
}
public void setCourses(String[] courses) {
	this.courses = courses;
}
@Override
public String toString() {
	return "Pojo_Post_Request [id=" + id + ", name=" + name + ", location=" + location + ", phone=" + phone
			+ ", courses=" + Arrays.toString(courses) + "]";
}



}
