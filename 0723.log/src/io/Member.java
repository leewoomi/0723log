package io;

import java.io.Serializable;

public class Member implements Serializable{

	private String name;
	private int age;
	//transient를 붙이면 저장 안됨.
	private transient String password;
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "member [name=" + name + ", age=" + age + ", password=" + password + ", id=" + id + "]";
	}
	
	
}
