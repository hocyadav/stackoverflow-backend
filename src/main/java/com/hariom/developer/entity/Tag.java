package com.hariom.developer.entity;

import java.util.List;
/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
public class Tag {
	String tagName;

	public Tag() {
		super();
	}

	public Tag(String tagName) {
		super();
		this.tagName = tagName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "Tag [tagName=" + tagName + "]";
	}
	
}
