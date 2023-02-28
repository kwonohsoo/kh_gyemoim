package com.gyemoim.dao.member;

import com.gyemoim.domain.member.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class MemberMypageDAOImpl implements MemberMypageDAO {
    @Inject
    private SqlSession sqlSession;
    private static String namespace = "com.gyemoim.dao.MemberMypageDAO";

    //마이페이지 조회
    @Override
    public MemberVO view(Long uNo) throws Exception {
        System.out.println("dao 실행");
        return sqlSession.selectOne(namespace + "MemberMypageMapper.view", uNo);
    }

    //마이페이지 업데이트
    @Override
    public void update(MemberVO memberVO) throws Exception {
        sqlSession.update(namespace+"MemberMypageMapper.update", memberVO);
    }
}
