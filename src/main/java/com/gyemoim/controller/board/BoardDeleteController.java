package com.gyemoim.controller.board;

import com.gyemoim.dto.board.BoardDeleteDTO;
import com.gyemoim.service.board.BoardDeleteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class BoardDeleteController {

  @Inject
  private BoardDeleteService boardDeleteService;

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public String delete(BoardDeleteDTO dto) throws Exception {
    boardDeleteService.delete(dto);
    return "redirect:/board/list";
  }

}
