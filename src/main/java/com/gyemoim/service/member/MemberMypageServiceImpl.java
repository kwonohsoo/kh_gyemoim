package com.gyemoim.service.member;

import com.gyemoim.dao.member.MemberMypageDAO;
import com.gyemoim.domain.member.MemberVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MemberMypageServiceImpl implements MemberMypageService {
   @Inject
    private MemberMypageDAO memberMypageDAO;

    //마이페이지 뷰
    @Override
    public MemberVO view(Long uNo) throws Exception {
        System.out.println("회원정보 띄우기");
        return memberMypageDAO.view(uNo);
    }


    //마이페이지 수정

    @Override
    public void update(MemberVO memberVO) throws Exception {
        System.out.println("회원정보 수정하기");
        memberMypageDAO.update(memberVO);
    }

}
