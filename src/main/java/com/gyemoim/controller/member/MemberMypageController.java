package com.gyemoim.controller.member;

import com.gyemoim.domain.member.MemberVO;
import com.gyemoim.dto.member.MypageDTO;
import com.gyemoim.service.member.MemberMypageService;
import org.springframework.http.HttpOutputMessage;
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
//        Integer uno =(Integer)session.getAttribute("uno");
//        MemberVO memberVO = service.view(uno);
//        model.addAttribute("my", memberVO);
        // memberVO객체에 "login"으로 세션안에 있는 속성들 가져와서 넣어주기
        MemberVO memberVO = (MemberVO)session.getAttribute("login");
        //model에 "my"로 멤버 vo객체의 값들 담아주기
        model.addAttribute("my", memberVO);
        // 서비스의 view 메소드 호출하는데 매개변수를 memberVO에서 가져오기
        service.view(memberVO.getUno());
    }


    //회원정보 수정

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePOST(MypageDTO mypageDTO, HttpSession session){
        System.out.println("update 돌아감");
        try {
            service.update(mypageDTO);
            MemberVO memberVO = (MemberVO)session.getAttribute("login");

            memberVO.setName(mypageDTO.getName()); //이름
            memberVO.setPassword(mypageDTO.getPassword()); // 비밀번호
            memberVO.setPhone(mypageDTO.getPhone()); //전화번호
            memberVO.setBankName(mypageDTO.getBankName()); //은행
            memberVO.setBankAccountNumber(mypageDTO.getBankAccountNumber()); //계좌번호
            memberVO.setAddress(mypageDTO.getAddress()); //주소
            memberVO.setAddresscode(mypageDTO.getAddresscode());//우편번호
            memberVO.setAddressdetail(mypageDTO.getAddressdetail());//상세주소

        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/member/mypage";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateGET(HttpSession session)throws Exception{
        System.out.println("get 방식");
        MemberVO memberVO = (MemberVO)session.getAttribute("login");
//        System.out.println(service.view(memberVO.getUno()).toString());
        return "member/mypage";
    }

    //회원정보 삭제
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(MemberVO memberVO, HttpSession session) throws Exception{
        System.out.println("회원정보 삭제");
        memberVO = (MemberVO) session.getAttribute("login");
        service.delete(memberVO);
        session.invalidate();
        return "redirect:/";
    }
    // 회원정보 삭제페이지 보여주는 컨트롤러
    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(MemberVO memberVO, HttpSession session) throws Exception {
        memberVO = (MemberVO) session.getAttribute("login");
        return "member/remove";
    }
}
