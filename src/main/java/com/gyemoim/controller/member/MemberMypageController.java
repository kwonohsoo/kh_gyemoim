package com.gyemoim.controller.member;

import com.gyemoim.domain.member.MemberVO;
import com.gyemoim.service.member.MemberMypageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
@RequestMapping("/member")
public class MemberMypageController {
    @Inject
    private MemberMypageService memberMypageService;
    //마이페이지 조회
    @RequestMapping(value ="/mypage", method = RequestMethod.GET)
    public String view(@RequestParam("uNo")Long uNo, MemberVO memberVO, Model model) throws  Exception{
        System.out.println("view 돌아감");
        model.addAttribute("my",memberMypageService.view(memberVO.getUNo()));
        return "member/mypage";

    }
    //마이페이지 수정
    @RequestMapping(value = "/mypage/update", method = RequestMethod.GET)
    public void updateGET(Long uNo, Model model)throws Exception{
        System.out.println(" get 방식");
        model.addAttribute(memberMypageService.view(uNo));

    }
    @RequestMapping(value = "/mypage/update", method = RequestMethod.POST)
    public String updatePOST(MemberVO memberVO)throws Exception{
        System.out.println("update 돌아감");
        memberMypageService.update(memberVO);
        return "member/mypage";
    }


}
