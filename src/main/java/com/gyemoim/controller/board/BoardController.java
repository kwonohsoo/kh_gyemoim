package com.gyemoim.controller.board;

import com.gyemoim.domain.board.BoardVO;
import com.gyemoim.domain.board.PageVO;
import com.gyemoim.domain.board.ReplyVO;
import com.gyemoim.dto.board.BoardListDTO;
import com.gyemoim.service.board.BoardService;
import com.gyemoim.service.board.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/board/")
public class BoardController {

  @Inject
  private BoardService boardService;
  @Inject
  private ReplyService replyService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String notice(Model model, @RequestParam(value = "nowPage", required = false) String nowPage, @RequestParam(value = "cntPerPager", required = false) String cntPerPage) throws Exception {
    int total = boardService.countBoard();

    if(nowPage == null && cntPerPage == null) {
      nowPage = "1";
      cntPerPage = "10";
    } else if(nowPage == null) {
      nowPage = "1";
    } else if (cntPerPage == null) {
      cntPerPage = "10";
    }

    PageVO vo = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));

    model.addAttribute("paging", vo);
    model.addAttribute("list", boardService.selectBoard(vo));

    return "board/notice";
  }

  @RequestMapping(value = "/read")
  public String read(Model model, @RequestParam("bid") int bid) throws Exception {
    List<ReplyVO> reply = replyService.reply(bid);
    model.addAttribute("board", boardService.readDetail(bid));
    model.addAttribute("reply", reply);
    return "board/read";
  }

  @RequestMapping(value = "/getSearchList", method = RequestMethod.GET)
  private String getSearchList(BoardListDTO dto, @RequestParam("type") String type, @RequestParam("keyword") String keyword, Model model) throws Exception {
    List<BoardVO> searchList = boardService.searchList(dto);
    System.out.println(searchList);
    model.addAttribute("listAll", searchList);
    return "/board/searchList";
  }

}
