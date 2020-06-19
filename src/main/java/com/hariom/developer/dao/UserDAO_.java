package com.hariom.developer.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hariom.developer.entity.Answer;
import com.hariom.developer.entity.Question;
import com.hariom.developer.entity.Tag;
import com.hariom.developer.entity.User_;
/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
@Repository
public class UserDAO_ implements GenericDB<User_>{

	private static Map<Integer, User_> allData;

	static {//dummy data : In memory data

		allData = new HashMap<Integer, User_>(){
			{
				User_ u1 = extracted();
				put(u1.getUserID(), u1);
				
				User_ u2 = extracted2();
				put(u2.getUserID(), u2);
			}

			private User_ extracted() {
				User_ u1 = new User_();
				u1.setName("Hariom Yadav");
				u1.setDesignation("Software Engineer");
				u1.setLocation("Bangalore, Karnataka");
				List<Question> qq = new LinkedList<Question>();
				//que start
				Question e = new Question("How to add elements of a Java8 stream into an existing List ?", null);
				Answer answer = new Answer();
				answer.setQueId(e.getQid());
				answer.setAnswer("As far as I can see, all other answers so far used a collector to add elements to an existing stream. However, there's a shorter solution, and it works for both sequential and parallel streams");
				
				e.getAllAnswers().add(answer);
				
				
				List<Tag> tags = new LinkedList();
				tags.add(new Tag("java"));
				e.setTags(tags);
				
				qq.add(e);
				Question e2 = new Question("How to add elements of a Java8 stream into an existing List ?", null);
				qq.add(e2);
				u1.setQuestions(qq );
				return u1;
			}
			
			
			private User_ extracted2() {
				User_ u1 = new User_();
				u1.setName("Omprakash");
				u1.setDesignation("Software Engineer 2");
				u1.setLocation("Bangalore, Karnataka");
				List<Question> qq = new LinkedList<Question>();
				Question e = new Question("How to add elements of a Java8 stream into an existing List ?", null);
				
				Answer answer = new Answer();
				answer.setQueId(e.getQid());
				answer.setAnswer("As far as I can see, all other answers so far used a collector to add elements to an existing stream. However, there's a shorter solution, and it works for both sequential and parallel streams");
				e.getAllAnswers().add(answer);
				
				List<Tag> tags = new LinkedList();
				tags.add(new Tag("java"));
				e.setTags(tags);
				
				qq.add(e);
				u1.setQuestions(qq );
				return u1;
			}
			
			
		};
	}

	@Override
	public Collection<User_> getAll() {
		return allData.values();
	}

	@Override
	public User_ getById(int id) {
		return allData.get(id);
	}

	@Override
	public void removeById(int id) {

	}

	@Override
	public void insert(User_ newObj) {

	}

	@Override
	public void update(User_ oldObj) {

	}

}
