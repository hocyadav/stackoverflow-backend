package com.hariom.developer.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.hariom.developer.util.NextID;

/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
public class Question {
	int qid;
	String question;
	List<Tag> tags = new LinkedList<Tag>();
	List<Answer> allAnswers = new LinkedList<Answer>();
	
//	public String getTagsStr() {
//		String collect = this.tags
//				.stream()
//				.map(it -> it.getTagName())
//				.collect(Collectors.joining(", "));
//		return collect;
//	}
	
	
	public Question() {
		super();
		this.qid = NextID.ansID();
	}
	public Question(String question, List<Tag> tags) {
		super();
		this.qid = NextID.ansID();
		this.question = question;
		this.tags = tags;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public List<Answer> getAllAnswers() {
		return allAnswers;
	}
	public void setAllAnswers(List<Answer> allAnswers) {
		this.allAnswers = allAnswers;
	}
	@Override
	public String toString() {
		return "Question [qid=" + qid + ", question=" + question + ", tags=" + tags + ", allAnswers=" + allAnswers
				+ "]";
	}
	
}
