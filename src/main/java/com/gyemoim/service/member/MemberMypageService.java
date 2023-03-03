package com.gyemoim.service.member;


import com.gyemoim.domain.member.MemberVO;
import com.gyemoim.dto.member.MypageDTO;

public interface MemberMypageService {
    //마이페이지 뷰
    public MemberVO view(Integer uno) throws Exception;

    //마이페이지 업데이트
    public void update(MypageDTO mypageDTO) throws Exception;

    //회원정보 삭제
    public void delete(MemberVO memberVO)throws Exception;

}
