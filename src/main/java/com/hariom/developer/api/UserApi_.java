package com.hariom.developer.api;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hariom.developer.entity.Question;
import com.hariom.developer.entity.User_;
import com.hariom.developer.service.UserService_;
/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */
@RestController
@RequestMapping("/user")
public class UserApi_ {

	@Autowired
	UserService_ service_;

	/**
	 * get all user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Collection<User_> getALL_() {
		return service_.getAll();
	}

	/**
	 * get user by id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User_ getUserByID(@PathVariable("id") int id) {
		return service_.getById(id);
	}

	/**
	 * add new question
	 * @param question
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public void addNewQue(
			@RequestBody Question question, 
			@PathVariable("id") int id) {
		System.out.println("new question : "+question);
		service_.addQuestionToUID(question, id);
	}

	/**
	 * get all notification
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/noti", method = RequestMethod.GET)
	public List<String> getAllNotification(@PathVariable("id") int id) {
		return service_.getAllNotificationForUser(id);
	}

	/**
	 * clear all notification
	 * @param id
	 */
	@RequestMapping(value = "/{id}/noti", method = RequestMethod.DELETE)
	public void cleanNotification(@PathVariable("id") int id) {
		service_.deleteNotiForUser(id);
	}
}
