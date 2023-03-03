package com.gyemoim.controller.board;

import com.gyemoim.domain.board.ReplyVO;
import com.gyemoim.dto.board.ReplyWriteDTO;
import com.gyemoim.service.board.ReplyWriteService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@RestController
@Controller
public class ReplyWriteController {

  @Inject
  private ReplyWriteService replyWriteService;
  @Autowired
  private SqlSession sqlSession;

  //댓글작성
  @ResponseBody
  @RequestMapping(value = "/replyWrite", method = RequestMethod.POST)
  public ResponseEntity<String> replyWrite(@RequestBody ReplyVO vo) {
    System.out.println("짜잔" + vo);
    ResponseEntity<String> entity = null;
    try {
      replyWriteService.replyWrite(vo);
      entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
        System.out.println("여기도 쫌 찍혀줄래?" + vo + entity);
    } catch (Exception e) {
      e.printStackTrace();
      entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return entity;
  }

}
