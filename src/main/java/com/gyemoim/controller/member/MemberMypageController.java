package com.gyemoim.controller.member;

import com.gyemoim.domain.member.MemberVO;
import com.gyemoim.dto.member.MypageDTO;
import com.gyemoim.service.member.MemberMypageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberMypageController {
    @Inject
    private MemberMypageService service;
    //회원정보 조회
    @RequestMapping(value ="/mypage", method = RequestMethod.GET)
    public void view(HttpSession session, Model model) throws  Exception{
        System.out.println("view 돌아감");
        Integer uno =(Integer)session.getAttribute("uno");
        MemberVO memberVO = service.view(uno);
        model.addAttribute("my", memberVO);
    }


    //회원정보 수정

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePOST(MypageDTO mypageDTO)throws Exception{
        System.out.println("update 돌아감");
        service.update(mypageDTO);
        return "redirect:/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public void updateGET(Integer uno, Model model)throws Exception{
        System.out.println("get 방식");
        model.addAttribute(service.view(uno));

    }

    //회원정보 삭제
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(MemberVO memberVO, HttpSession session) throws Exception{
        System.out.println("회원정보 삭제");
        service.delete(memberVO);
        session.invalidate();
        return "redirect:/";
    }


}
