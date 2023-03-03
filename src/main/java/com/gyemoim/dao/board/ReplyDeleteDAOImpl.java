package com.gyemoim.dao.board;

import com.gyemoim.domain.board.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
@Repository
public class ReplyDeleteDAOImpl implements ReplyDeleteDAO {
    @Inject
    private SqlSession sqlSession;
    private static String namespace = "com.gyemoim.dao.board.ReplyDeleteDAO";
    @Override
    public void replyDelete(ReplyVO vo) throws Exception {
        System.out.println("댓글삭제 DAO" + vo);
        sqlSession.selectOne(namespace+".replyDelete",vo);
    }
}
