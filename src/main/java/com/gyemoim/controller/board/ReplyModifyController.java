package com.gyemoim.controller.board;

import com.gyemoim.domain.board.ReplyVO;
import com.gyemoim.service.board.ReplyModifyService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@Controller
public class ReplyModifyController {

  @Inject
  private ReplyModifyService replyModifyService;
  @Autowired
  private SqlSession sqlSession;


  @ResponseBody
  @RequestMapping(value = "/replyModify", method = RequestMethod.POST)
  public ResponseEntity<String> replyModify(@RequestBody ReplyVO vo) {
   System.out.println("댓글 수정 컨트롤러" + vo);
    ResponseEntity<String> entity = null;
    try {
      replyModifyService.replyModify(vo);
      entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        System.out.println("수정 성공" + vo + entity);
    } catch (Exception e) {
      e.printStackTrace();
      entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return entity;
  }

}
