package com.gyemoim.service.member;

import com.gyemoim.dto.member.RegisterDTO;

public interface MemberRegisterService {
    void registerMember(RegisterDTO registerDTO) throws Exception ;

    int checkMember(String email) throws Exception;

}
