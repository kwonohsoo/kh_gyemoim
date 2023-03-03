package com.gyemoim.dao.board;

import com.gyemoim.domain.board.ReplyVO;
import com.gyemoim.dto.board.ReplyWriteDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ReplyWriteDAOImpl implements ReplyWriteDAO {

  @Inject
  private SqlSession sqlSession;
  private static String namespace = "com.gyemoim.dao.board.ReplyWriteDAO";

  //댓글 작성
  @Override
  public void replyWrite(ReplyVO vo) throws Exception {
    System.out.println("댓글작성 DAO" + vo);
    sqlSession.insert("ReplyWriteMapper.replyWrite",vo);
  }

  //댓글 조회
  @Override
  public List<ReplyVO> reply(int bid) throws Exception {
    return sqlSession.selectList("ReplyWriteMapper.reply", bid);
  }

}
