package com.hariom.developer.service;import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hariom.developer.dao.NotificationDao;
import com.hariom.developer.dao.UserDAO_;
import com.hariom.developer.entity.Answer;
import com.hariom.developer.entity.Notification;
import com.hariom.developer.entity.Question;
import com.hariom.developer.entity.User_;
/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
@Service
public class UserService_ implements GenericService<User_>{

	@Autowired
	UserDAO_ userDao;

	@Autowired
	NotificationDao notiDao;

	@Override
	public Collection<User_> getAll() {
		return userDao.getAll();
	}

	@Override
	public User_ getById(int id) {
		return userDao.getById(id);
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

	/**
	 * add new question to user database
	 * @param question
	 * @param uid
	 */
	public void addQuestionToUID(Question question, int uid) {
		//get uid 
		//add 
		//add to bloacking queue 
		//add to notification key-value 
		//		BlockingQueue<Question> qq = notiDao.getBQ();
		//		try {
		//			qq.put(question);
		//		} catch (InterruptedException e) {
		//			e.printStackTrace();
		//		}
		//add key = userid, value its question

		Notification nn = notiDao.getById(uid);
		if(nn == null) {
			nn = new Notification();
			nn.setUserId(uid);
		}
		nn.getListOfQuestions().add(question.getQuestion());

		notiDao.insert(nn);

		int size = nn.getListOfQuestions().size();


		User_ user__ = userDao.getById(uid);
		System.out.println(user__);
		user__.setNotificationCount(size);
		user__.getQuestions().add(question);

	}

	/**
	 * get all notification for a user
	 * @param id
	 * @return
	 */
	public List<String> getAllNotificationForUser(int id) {
		if(notiDao.getById(id) == null) 
			return null;

		Notification nn = notiDao.getById(id);
		List<String> listOfQuestions = nn.getListOfQuestions();
		return listOfQuestions;
	}

	/**
	 * clear all notification
	 * @param id
	 */
	public void deleteNotiForUser(int id) {
		if(notiDao.getById(id) != null) {
			notiDao.removeById(id);
		}

		userDao.getById(id).setNotificationCount(0);

	}

	public List<Question> getAllQueFromALlUser() {
		Collection<User_> all = this.getAll();
		System.out.println(all);

		List<Question> qList = new LinkedList();

		for(User_ u : all) {
			System.out.println(u);
			List<Question> questions = u.getQuestions();
			questions.stream()
			.filter(it -> it != null)
			.forEach(it -> qList.add(it));
		}
		return qList;
	}

	public Question getQueByID(int id) {
		List<Question> allQueFromALlUser = getAllQueFromALlUser();

		for(Question q : allQueFromALlUser) {
			if(q.getQid() == id) {
				return q;
			}
		}
		return null;
	}

	public List<Answer> getQueAllAns(int qid) {
		return getQueByID(qid).getAllAnswers();
	}

	/**
	 * add new answer
	 * @param answer
	 * @param id
	 */
	public void postAns(Answer answer, int id) {
		answer.setQueId(id);
		getQueByID(id).getAllAnswers().add(answer);
	}

	public Answer getSingleAns(int qid, int ansID) {
		List<Answer> queAllAns = getQueAllAns(qid);

		for(Answer answer : queAllAns) {
			if(answer.getAnsId() == ansID) {
				return answer;
			}
		}

		return null;
	}

	public void up(int qid, int ansID) {
		Answer ans = getSingleAns(qid, ansID);
		ans.setVoteCount(ans.getVoteCount() + 1);
	}

	public void down(int qid, int ansID) {
		Answer ans = getSingleAns(qid, ansID);
		ans.setVoteCount(ans.getVoteCount() - 1);
	}

}
