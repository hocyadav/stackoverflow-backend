package com.hariom.developer.util;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * Next Unique ID
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
public class NextID {

	private static final AtomicInteger questionUniqueID = new AtomicInteger(0);
	private static final AtomicInteger answerUniqueID = new AtomicInteger(0);
	private static final AtomicInteger postID = new AtomicInteger(0);
	private static final AtomicInteger userUniqueID = new AtomicInteger(0);

	public static Integer getQuestionUniqueID() {
		return questionUniqueID.incrementAndGet();
	}

	public static Integer getAnswerUniqueID() {
		return answerUniqueID.incrementAndGet();
	}

	public static Integer postID() {
		return postID.incrementAndGet();
	}
	
	public static Integer getUserUniqueID() {
		return userUniqueID.incrementAndGet();
	}
	
}
