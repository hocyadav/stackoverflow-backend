package com.hariom.developer.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hariom.developer.entity.Answer;
/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
@Repository
public class AnswerDao implements GenericDB<Answer>{
	
	private static Map<Integer, Answer> allData;

	static {

		allData = new HashMap<Integer, Answer>(){
			{
				Answer ans = new Answer();
				put(ans.getAnsId(), ans);
				
			}
		};
	}

	@Override
	public Collection<Answer> getAll() {
		return allData.values();
	}

	@Override
	public Answer getById(int id) {
		return allData.get(id);
	}

	@Override
	public void removeById(int id) {
		allData.remove(id);
		
	}

	@Override
	public void insert(Answer newObj) {
		allData.put(newObj.getAnsId(), newObj);
		
	}

	@Override
	public void update(Answer oldObj) {
		
	}

}
