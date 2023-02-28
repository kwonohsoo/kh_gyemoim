package com.gyemoim.service.member;


import com.gyemoim.domain.member.MemberVO;

public interface MemberMypageService {
    //마이페이지 뷰
    public MemberVO view(Long uNo) throws Exception;

    //마이페이지 업데이트
    public void update(MemberVO memberVO) throws Exception;

}
