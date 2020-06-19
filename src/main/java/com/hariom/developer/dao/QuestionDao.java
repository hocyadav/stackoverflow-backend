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
/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
@Repository
public class QuestionDao implements GenericDB<Question>{
	
	
	private static Map<Integer, Question> allData;

	static {

		allData = new HashMap<Integer, Question>(){
			{
				Question question = extracted();
				
				put(question.getQid(), question);
				
				Question question2 = new Question();
				put(question2.getQid(), question2);
				
			}

			private Question extracted() {
				Question question = new Question();
				question.setQuestion("question asjhakjs asjhakjshkja");
				List<Tag> listTag = new LinkedList();
				listTag.add(new Tag("java"));
				listTag.add(new Tag("javascript"));
				
				Answer e = new Answer();
				e.setAnswer("answer aslkjlakjdlasd ");
				e.setQueId(question.getQid());
				question.getAllAnswers().add(e);
				
				Answer e2 = new Answer();
				e2.setAnswer("answer 2 ");
				e2.setQueId(question.getQid());
				question.getAllAnswers().add(e2);
				return question;
			}
		};
	}

	public Collection<Question> getAll() {
		return allData.values();
	}

	public Question getById(int id) {
		return allData.get(id);
	}

	public void removeById(int id) {
		allData.remove(id);
	}

	public void insert(Question newObj) {
		allData.put(newObj.getQid(), newObj);
	}

	public void update(Question oldObj) {
		int qid = oldObj.getQid();
		Question qq = allData.get(qid);
		
		qq.setQuestion(oldObj.getQuestion());//update question 
		oldObj.getTags().stream().forEach(it -> qq.getTags().add(it));//add tag
		
		allData.put(qid, qq);
	}

}
