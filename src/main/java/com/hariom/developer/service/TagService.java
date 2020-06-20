package com.hariom.developer.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hariom.developer.dao.NotificationDao;
import com.hariom.developer.dao.TagDao;
import com.hariom.developer.entity.Notification;
import com.hariom.developer.entity.Question;
import com.hariom.developer.entity.Tag;
import com.hariom.developer.entity.User_;
/**
 * 
 * @author Hariom Yadav
 *
 */
@Service
public class TagService {
	
	@Autowired
	TagDao tagDao;
	
	@Autowired
	UserService_ userService_;
	
	@Autowired
	NotificationDao notificationDao;
	
	
	Collection<Set<Integer>> getAllTagUserDB(){
		return tagDao.getAllTagUserDB();
	}
	
	public Set<Integer> getAllUserSetForA_Tag(String tagName) {
		return tagDao.getAllUserSetForA_Tag(tagName);
	}
	
	public void removeTag(String tagName) {
		tagDao.removeTag(tagName);
	}

	public void insertNewTag(String tagName, Set<Integer> setOfUsers) {
		tagDao.insertNewTag(tagName, setOfUsers);
	}
	
	public void insertNewUser(String tagName, int userId) {
		tagDao.insertNewUser(tagName, userId);
		
	}
	
	public List<String> queToSetOfTag(Question question) {
		List<String> collect = 
				queToSetOfTag_UTIL(question)
				.stream()
				.map(m -> m.getTagName())
				.collect(Collectors.toList());
		return collect;
	}
	
	public List<Tag> queToSetOfTag_UTIL(Question newQue) {
		List<Tag> tags = newQue.getTags();
		if(tags != null) {
			return tags;
		}
		return new LinkedList<Tag>();
	}
	
	public Set<Integer> allUserSetForAQuestion(Question newQue) {
		
		Set<Integer> userForNewQuestion = new HashSet<>();
		List<String> allTags = queToSetOfTag(newQue);
		for(String t : allTags) {
			userForNewQuestion.addAll(getAllUserSetForA_Tag(t));
		}
		return userForNewQuestion;
	}
	
	/**
	 * Push notification for new question 
	 * @param newQue
	 */
	public void pushNotification(Question newQue) {
		Set<Integer> allUserSetForAQuestion = allUserSetForAQuestion(newQue);
		
		for(Integer id : allUserSetForAQuestion) {
			User_ u = userService_.getById(id);
			
			Notification nn = notificationDao.getById(u.getUserID());
			if(nn == null) {
				nn = new Notification();
				nn.setUserId(u.getUserID());
			}
			nn.getListOfQuestions().add(newQue.getQuestion());
			notificationDao.insert(nn);
			
			int size = nn.getListOfQuestions().size();
			
			u.setNotificationCount(size);
			//u.getQuestions().add(newQue);
		}
	}
	
}
