package com.hariom.developer.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

@Repository
public class TagDao{
	private static Map<String, Set<Integer>> allData;

	static {

		allData = new HashMap<String, Set<Integer>>(){
			{
				Set<Integer> set = new HashSet();
				set.add(1);
				set.add(2);
				put("java", set);
				
				Set<Integer> set2 = new HashSet();
				set2.add(2);
				put("python", set2);
			}

		};
	}
	
	
	public Collection<Set<Integer>> getAllTagUserDB(){
		return allData.values();
	}
	
	public Set<Integer> getAllUserSetForA_Tag(String tagName) {
		return allData.get(tagName);
	}
	
	public void removeTag(String tagName) {
		allData.remove(tagName);
	}

	public void insertNewTag(String tagName, Set<Integer> setOfUsers) {
		allData.put(tagName, setOfUsers);
	}
	
	public void insertNewUser(String tagName, int userId) {
		if(allData.containsKey(tagName)) {
			allData.get(tagName).add(userId);
		}else {
			Set<Integer> set3 = new HashSet();
			set3.add(userId);
			
			allData.put(tagName, set3);
		}
	}
	
}
