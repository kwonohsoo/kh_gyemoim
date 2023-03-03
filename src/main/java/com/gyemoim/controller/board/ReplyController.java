package com.gyemoim.controller.board;

import com.gyemoim.service.board.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
public class ReplyController {

  @Inject
  private ReplyService replyService;


}
