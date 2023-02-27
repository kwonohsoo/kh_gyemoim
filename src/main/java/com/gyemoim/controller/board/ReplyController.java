package com.gyemoim.controller.board;

import com.gyemoim.domain.ReplyVO;
import com.gyemoim.service.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ReplyController {

  @Inject
  private ReplyService replyService;

  @RequestMapping(value = "replyWrite")
  public void reply(Model model, @RequestParam("bid") int bid) throws Exception {

  }

}
