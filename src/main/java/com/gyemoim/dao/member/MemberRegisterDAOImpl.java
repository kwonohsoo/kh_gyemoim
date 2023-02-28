package com.gyemoim.dao.member;

import com.gyemoim.dto.member.RegisterDTO;
import jdk.jfr.Name;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRegisterDAOImpl implements MemberRegisterDAO {

    @Autowired(required=false)
    @Name("SqlSession")
    SqlSession sql;

    private static String namespace = "com.gyemoim.dao.MemberRegisterDAO";
  //회원 가입
    @Override
    public void registerMember(RegisterDTO registerDTO) throws Exception {
        System.out.println("회원가입 DAO" + registerDTO);
     sql.insert(namespace +"MemberRegisterMapper.registerMember", registerDTO);
    }

    //중복체크

    @Override
    public int checkMember(String email) throws Exception {
        System.out.println("중복체크 DAO");
        Integer result = sql.selectOne(namespace +"MemberRegisterMapper.checkMember", email);
        return result;
    }
}
