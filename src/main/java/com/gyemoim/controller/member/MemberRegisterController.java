package com.gyemoim.controller.member;

import com.gyemoim.dto.member.RegisterDTO;
import com.gyemoim.service.member.MemberRegisterService;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberRegisterController {

  @Autowired(required = false)
  @Name("MemberRegisterService")
  MemberRegisterService memberRegisterService;

  @RequestMapping(value = "/register")
  public String register() {
    return "member/register";
  }

  //회원가입
  @RequestMapping(value = "/registerPost")
  public String registerPost(RegisterDTO registerDTO) throws Exception {
    System.out.println("또잉또잉" + registerDTO);
    memberRegisterService.registerMember(registerDTO);
    return "member/login";
  }

  //중복체크
  @ResponseBody
  @RequestMapping(value = "/checkMember", method = {RequestMethod.POST, RequestMethod.GET})
  public int checkMember(@RequestParam("email") String email) throws Exception {
    System.out.println("중복체크 컨트롤러");
    Integer result = memberRegisterService.checkMember(email);
    System.out.println("email" + email);
    System.out.println("result" + result);
    return result;

  }

}
