package com.gyemoim.controller.board;

import com.gyemoim.domain.board.ReplyVO;
import com.gyemoim.service.board.ReplyDeleteService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@Controller
public class ReplyDeleteController {

  @Inject
  private ReplyDeleteService replyDeleteService;
  @Autowired
  private SqlSession sqlSession;


  @ResponseBody
  @RequestMapping(value = "/replyDelete", method = RequestMethod.POST)
  public ResponseEntity<String> replyModify(@RequestBody ReplyVO vo) {
    System.out.println("댓글 삭제 컨트롤러" + vo);
    ResponseEntity<String> entity = null;
    try {
      replyDeleteService.replyDelete(vo);
      entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
      System.out.println("삭제 성공" + vo + entity);
    } catch (Exception e) {
      e.printStackTrace();
      entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return entity;
  }

}
