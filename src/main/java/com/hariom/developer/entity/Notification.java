package com.hariom.developer.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
public class Notification {
	int userId;
	List<String> listOfQuestions = new LinkedList();
	
	public Notification() {
		super();
	}
	public Notification(int userId, List<String> listOfQuestions) {
		super();
		this.userId = userId;
		this.listOfQuestions = listOfQuestions;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<String> getListOfQuestions() {
		return listOfQuestions;
	}
	public void setListOfQuestions(List<String> listOfQuestions) {
		this.listOfQuestions = listOfQuestions;
	}
	
}
