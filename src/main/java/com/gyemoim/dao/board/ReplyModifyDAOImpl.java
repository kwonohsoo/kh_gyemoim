package com.gyemoim.dao.board;

import com.gyemoim.domain.board.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class ReplyModifyDAOImpl implements ReplyModifyDAO {

    @Inject
    private SqlSession sqlSession;
    private static String namespace = "com.gyemoim.dao.board.ReplyModifyDAO";

   //댓글 수정
    @Override
    public void replyModify(ReplyVO vo) throws Exception {
        System.out.println("댓글수정 DAO" + vo);
        sqlSession.update("ReplyModifyMapper.replyModify",vo);
    }
}
