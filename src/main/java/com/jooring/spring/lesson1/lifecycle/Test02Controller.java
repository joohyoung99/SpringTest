package com.jooring.spring.lesson1.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jooring.spring.lesson1.lifecycle.model.Comment;

@RestController
@RequestMapping("/lesson01/test02")
public class Test02Controller {
	
	@RequestMapping("/1")
	
	public List<Map<String, Object>> printList(){
		
	List<Map<String, Object>> list = new ArrayList<>();

	Map<String, Object> movieInfo = new HashMap<>();
	
	movieInfo.put("rate", 15);
	movieInfo.put("director", "봉준호");
	movieInfo.put("time", 131);
	movieInfo.put("title", "기생충");
	list.add(movieInfo);
	
	movieInfo = new HashMap<>();
	
	movieInfo.put("rate", 0);
	movieInfo.put("director", "로베르토 베니니");
	movieInfo.put("time", 116);
	movieInfo.put("title", "인생은 아름다워");
	list.add(movieInfo);
	
	movieInfo = new HashMap<>();
	
	movieInfo.put("rate", 12);
	movieInfo.put("director", "크리스토퍼 놀란");
	movieInfo.put("time", 147);
	movieInfo.put("title", "인셉션");
	list.add(movieInfo);
	
	movieInfo = new HashMap<>();
	
	movieInfo.put("rate", 19);
	movieInfo.put("director", "윤종빈");
	movieInfo.put("time", 133);
	movieInfo.put("title", "범죄와의 전쟁: 나쁜놈들 전성시대");
	list.add(movieInfo);
	
	movieInfo = new HashMap<>();
	
	movieInfo.put("rate", 15);
	movieInfo.put("director", "프란시스 로렌스");
	movieInfo.put("time", 137);
	movieInfo.put("title", "헝거게임");
	list.add(movieInfo);
	
	return list;
	
	
	}
	
	
	@RequestMapping("/2")
	public List<Comment> printObject() {
		
		List<Comment> commentlist = new ArrayList<Comment>();
		Comment user1 = new Comment();
		user1.setTitle("안녕하세요 가입인사 드립니다.");
		user1.setUser("hagulu");
		user1.setContent("안녕하세요 . 가입했아요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		
		
		Comment user2 = new Comment();
		user2.setTitle("헐 대박");
		user2.setUser("bada");
		user2.setContent("오늘 목요일이었어... 금요일인줄");
		
		Comment user3 = new Comment();
		user3.setTitle("오늘 데이트 한 이야기 해드릴게요");
		user3.setUser("dulumary");
		user3.setContent(".... ");
		
		commentlist.add(user1);
		commentlist.add(user2);
		commentlist.add(user3);
		
		return commentlist;
		
		
	}
	
	@RequestMapping("/3")

	public ResponseEntity<Comment> entity(){
		
		Comment comment = new Comment();
		
		comment.setTitle("안녕하세요 가입인사 드립니다.");
		comment.setUser("hagulu");
		comment.setContent("안녕하세요 . 가입했아요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
	
		
		ResponseEntity<Comment> entity = new ResponseEntity(comment, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	
	}
	
}
