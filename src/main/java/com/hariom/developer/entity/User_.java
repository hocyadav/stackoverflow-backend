package com.hariom.developer.entity;

import java.util.LinkedList;
import java.util.List;

import com.hariom.developer.util.NextID;
/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
public class User_ {
	int userID;
	String name;
	int reputation;
	String designation;
	String location;
	List<Tag> userTags = new LinkedList();
	List<Question> questions = new LinkedList();
	int notificationCount;
	
	public User_() {
		super();
		userID = NextID.userID();
	}
	public User_(String name) {
		super();
		userID = NextID.userID();
		this.name = name;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReputation() {
		return reputation;
	}
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Tag> getUserTags() {
		return userTags;
	}
	public void setUserTags(List<Tag> userTags) {
		this.userTags = userTags;
	}
	public int getNotificationCount() {
		return this.notificationCount;
	}
	public void setNotificationCount(int notificationCount) {
		this.notificationCount = notificationCount;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "User_ [userID=" + userID + ", name=" + name + ", reputation=" + reputation + ", designation="
				+ designation + ", location=" + location + ", userTags=" + userTags + ", questions=" + questions
				+ ", notificationCount=" + notificationCount + "]";
	}
	
	
}
