package com.gyemoim.service.member;

import com.gyemoim.dao.member.MemberRegisterDAO;
import com.gyemoim.dto.member.RegisterDTO;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberRegisterServiceImpl implements  MemberRegisterService {
    @Autowired(required=false)
          @Name("MemberRegisterDAO")
    MemberRegisterDAO memberRegisterDAO;

    //회원가입
    @Override
    public void registerMember(RegisterDTO registerDTO) throws Exception {
        System.out.println("회원가입 Service " +registerDTO );
        memberRegisterDAO.registerMember(registerDTO);
    }

    //중복체크

    @Override
    public int checkMember(String email) throws Exception {
        System.out.println("중복체크 Service "  );
        Integer result = memberRegisterDAO.checkMember(email);
        return result;
    }
}
