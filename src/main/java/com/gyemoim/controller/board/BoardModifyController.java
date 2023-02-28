package com.gyemoim.controller.board;

import com.gyemoim.dto.board.BoardWriteDTO;
import com.gyemoim.service.board.BoardModifyService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;

@Controller
public class BoardModifyController {
    @Autowired
    private SqlSession sqlSession;
    @Inject
    private BoardModifyService service;
    @RequestMapping(value = "/modifyPage")
    public String modify() {
        return "board/modifyPage";
    }

    @RequestMapping(value = "/modifyPost" ,method = RequestMethod.POST)
    public String modifyPost(BoardWriteDTO dto, RedirectAttributes request) throws Exception {
       //logger.info("write()");
        System.out.println("modifyPost!!");
        service.modify(dto);
        //BoardWriteDAO dao = sqlSession.getMapper(BoardWriteDAO.class);
        //dao.write(request.getParameter("name"), request.getParameter("title"), request.getParameter("content"));
        request.addFlashAttribute("message","Sucess!");
        return "redirect:/notice";
    }

}
