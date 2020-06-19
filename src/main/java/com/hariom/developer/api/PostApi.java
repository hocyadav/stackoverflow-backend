package com.hariom.developer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hariom.developer.entity.Answer;
import com.hariom.developer.entity.Question;
import com.hariom.developer.service.QuestionService;
import com.hariom.developer.service.UserService_;
import com.hariom.developer.util.Constants_;
/**
 * 
 * @author Hariom Yadav | 20-Jun-2020
 *
 */

@RestController
@RequestMapping("/post")
public class PostApi {

	@Autowired
	QuestionService queService;

	@Autowired
	UserService_ uService;

	/**
	 * all post
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Question> getALL_() {
		return uService.getAllQueFromALlUser();
	}

	/**
	 * get question by id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET)
	public Question getQueById(@PathVariable("id") int id) {
		return uService.getQueByID(id);
	}

	/**
	 * add new answer
	 * @param answer
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",
			method = RequestMethod.POST)
	public String postANs(
			@RequestBody Answer answer, 
			@PathVariable("id") int id) {
		uService.postAns(answer, id);
		return Constants_.ANSWER_UPDTED;
	}

	/**
	 * list of all answers
	 * @param qid
	 * @return
	 */
	@RequestMapping(value = "/{qid}/ans",
			method = RequestMethod.GET)
	public List<Answer> getAllAns(@PathVariable("qid") int qid) {
		return uService.getQueAllAns(qid);
	}

	/**
	 * get answer by answer id
	 * @param qid
	 * @param ansID
	 * @return
	 */
	@RequestMapping(value = "/{qid}/ans/{ansID}",
			method = RequestMethod.GET)
	public Answer getSingleAns(@PathVariable("qid") int qid, 
			@PathVariable("ansID") int ansID) {
		return uService.getSingleAns(qid, ansID);
	}

	/**
	 * up vote
	 * @param qid
	 * @param ansID
	 * @return
	 */
	@RequestMapping(value = "/{qid}/ans/{ansID}/up",
			method = RequestMethod.GET)
	public Answer up(@PathVariable("qid") int qid, 
			@PathVariable("ansID") int ansID) {
		uService.up(qid, ansID);
		return uService.getSingleAns(qid, ansID);
	}

	/**
	 * down vote
	 * @param qid
	 * @param ansID
	 * @return
	 */
	@RequestMapping(value = "/{qid}/ans/{ansID}/down",
			method = RequestMethod.GET)
	public Answer down(@PathVariable("qid") int qid, 
			@PathVariable("ansID") int ansID) {
		uService.down(qid, ansID);
		return uService.getSingleAns(qid, ansID);
	}

}
