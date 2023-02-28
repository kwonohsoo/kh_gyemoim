package com.gyemoim.dao.member;

import com.gyemoim.dto.member.RegisterDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRegisterDAO {
    //회원 가입
    void registerMember(RegisterDTO registerDTO) throws Exception;

    //중복체크
    int checkMember(String email) throws Exception;

}
