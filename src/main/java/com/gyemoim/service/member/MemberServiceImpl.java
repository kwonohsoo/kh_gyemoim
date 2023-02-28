package com.gyemoim.service.member;

import com.gyemoim.dao.member.MemberDAO;
import com.gyemoim.domain.member.MemberVO;
import com.gyemoim.dto.member.LoginDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {
  @Inject
  private MemberDAO memberDAO;

  @Override
  public MemberVO login(LoginDTO dto) throws Exception {
    return memberDAO.login(dto);
  }

  @Override
  public void keepLogin(Map<String, Object> map) throws Exception {
    System.out.println("service에서 dao keepLogin 수행.");
    memberDAO.keepLogin(map);
  }

  @Override
  public MemberVO checkLoginBefore(String value) {
    return memberDAO.checkMemberWithSessionKey(value);
  }
}
