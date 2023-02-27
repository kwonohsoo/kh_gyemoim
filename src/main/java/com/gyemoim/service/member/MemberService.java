package com.gyemoim.service.member;

import com.gyemoim.domain.member.MemberVO;
import com.gyemoim.dto.LoginDTO;

import java.util.Map;

public interface MemberService {

    MemberVO login(LoginDTO dto) throws Exception;

    void keepLogin( Map<String, Object> paramMap) throws Exception;

    public MemberVO checkLoginBefore(String value);
}
