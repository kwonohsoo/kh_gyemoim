package com.gyemoim.dao.member;

import com.gyemoim.domain.member.MemberVO;
import com.gyemoim.dto.member.MypageDTO;

public interface MemberMypageDAO {
    //회원정보 읽어오기.
    public MemberVO view(Integer uno) throws Exception;

    //회원정보 업데이트
    public void update(MypageDTO mypageDTO) throws Exception;

    //회원정보 삭제
    public void delete(MemberVO memberVO)throws Exception;
}
