package com.hariom.developer.util;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
public class NextID {

	private static final AtomicInteger queID = new AtomicInteger(0);
	private static final AtomicInteger ansID = new AtomicInteger(0);
	private static final AtomicInteger postID = new AtomicInteger(0);
	private static final AtomicInteger userID = new AtomicInteger(0);
	private static final AtomicInteger notificationID = new AtomicInteger(0);

	public static Integer queID() {
		return queID.incrementAndGet();
	}

	public static Integer ansID() {
		return ansID.incrementAndGet();
	}

	public static Integer postID() {
		return postID.incrementAndGet();
	}
	
	public static Integer userID() {
		return userID.incrementAndGet();
	}
	
	public static Integer notificationID() {
		return notificationID.incrementAndGet();
	}
	
}
