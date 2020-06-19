package com.hariom.developer.service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hariom.developer.dao.QuestionDao;
import com.hariom.developer.dao.UserDAO_;
import com.hariom.developer.entity.Answer;
import com.hariom.developer.entity.Question;
import com.hariom.developer.entity.User_;
/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
@Service
public class QuestionService implements GenericService<Question>{

	@Autowired
	QuestionDao queDB;
	
	@Autowired
	UserDAO_ userDB;

	@Override
	public Collection<Question> getAll() {

		return queDB.getAll();
	}

	@Override
	public Question getById(int id) {
		return queDB.getById(id);
	}

	@Override
	public void removeById(int id) {
		queDB.removeById(id);

	}

	@Override
	public void insert(Question newObj) {
		queDB.insert(newObj);
	}

	@Override
	public void update(Question oldObj) {
		queDB.update(oldObj);
	}


	public Answer getQueAns(int qid, int aid) {
		List<Answer> allAnswers = queDB.getById(qid).getAllAnswers();
		List<Answer> collect = allAnswers
				.stream()
				.filter(f -> f.getAnsId() == aid)
				.collect(Collectors.toList());

		return (collect.size() == 1) ? collect.get(0) : null;
	}
	
	public List<Answer> getQueAllAns(int qid) {
		return queDB.getById(qid).getAllAnswers();
	}
	

	public Answer getSingleAns(int qid, int ansID) {
		 List<Answer> collect = getQueAllAns(qid).stream().filter(it -> it.getAnsId() == ansID).collect(Collectors.toList());
		 return (collect.size() > 0) ? collect.get(0) : null;
	}

	public void up(int qid, int ansID) {
		//get ans and +1
		Answer ans = getQueAns(qid, ansID);
		ans.setVoteCount(ans.getVoteCount() + 1);
		
	}
	
	public void down(int qid, int ansID) {
		Answer ans = getQueAns(qid, ansID);
		ans.setVoteCount(ans.getVoteCount() - 1);
		
	}

	/**
	 * List of all questions
	 * @return
	 */
	public List<Question> getAllQueFromALlUser() {
		//get all user
		Collection<User_> all = userDB.getAll();
		System.out.println(all);
		List<Question> list = new LinkedList();
		
		for(User_ user_ : all) {
			List<Question> questions = user_.getQuestions();
			System.out.println(questions);
			list.addAll(questions);
		}
		
		return list;
		
	}

}
