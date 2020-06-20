package com.hariom.developer.entity;

import com.hariom.developer.util.NextID;
/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
public class Answer {
	int ansId;
	int queId;
	String answer;
	int voteCount;
	
	public Answer() {
		super();
		this.ansId = NextID.getAnswerUniqueID();
	}
	
	public Answer(int queId, String answer, int voteCount) {
		super();
		this.ansId = NextID.getAnswerUniqueID();
		this.queId = queId;
		this.answer = answer;
		this.voteCount = voteCount;
	}
	
	public int getAnsId() {
		return ansId;
	}
	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}
//	public int getQueId() {
//		return queId;
//	}
	public void setQueId(int queId) {
		this.queId = queId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	@Override
	public String toString() {
		return "Answer [ansId=" + ansId + ", queId=" + queId + ", answer=" + answer + ", voteCount=" + voteCount + "]";
	}
	
}
