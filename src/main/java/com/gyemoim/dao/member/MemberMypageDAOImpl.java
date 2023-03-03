package com.gyemoim.dao.member;

import com.gyemoim.domain.member.MemberVO;
import com.gyemoim.dto.member.MypageDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class MemberMypageDAOImpl implements MemberMypageDAO {
    @Inject
    private SqlSession sqlSession;
    private static String namespace = "com.gyemoim.dao.member.MemberMypageDAO";

    //마이페이지 조회
    @Override
    public MemberVO view(Integer uno) throws Exception {
        System.out.println("dao 실행");
        MemberVO memberVO = sqlSession.selectOne(namespace+".view", uno);
        return memberVO;
    }

    //마이페이지 업데이트
    @Override
    public void update(MypageDTO mypageDTO) throws Exception {
        sqlSession.update(namespace+".update", mypageDTO);
    }

    //회원정보 삭제
    @Override
    public void delete(MemberVO memberVO) throws Exception {
        sqlSession.delete(namespace+".delete", memberVO);
    }
}
