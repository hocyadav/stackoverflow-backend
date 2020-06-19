package com.hariom.developer.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.stereotype.Repository;

import com.hariom.developer.entity.Notification;
import com.hariom.developer.entity.Question;
/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
@Repository
public class NotificationDao implements GenericDB<Notification>{

	private static BlockingQueue<Question> blockingQueue = new ArrayBlockingQueue(10);
	
	private static Map<Integer, Notification> allData;

	static {//dummy data : In memory data

		allData = new HashMap<Integer, Notification>(){
			{
				Notification n = new Notification();
				n.setUserId(1);
				put(n.getUserId(), n);
			}
		};
	}
	
	@Override
	public Collection<Notification> getAll() {
		return allData.values();
	}

	@Override
	public Notification getById(int id) {
		return allData.get(id);
	}

	@Override
	public void removeById(int id) {
		allData.remove(id);
		
	}

	@Override
	public void insert(Notification newObj) {
		allData.put(newObj.getUserId(), newObj);
	}

	@Override
	public void update(Notification oldObj) {
		
	}
	
	public BlockingQueue<Question> getBQ() {
		return blockingQueue;
	}

}
