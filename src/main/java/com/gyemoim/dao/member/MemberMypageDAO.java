package com.gyemoim.dao.member;

import com.gyemoim.domain.member.MemberVO;

public interface MemberMypageDAO {
    //회원정보 읽어오기.
    public MemberVO view(Long uNo) throws Exception;

    //mypage 업데이트
    public void update(MemberVO memberVO) throws Exception;

}
