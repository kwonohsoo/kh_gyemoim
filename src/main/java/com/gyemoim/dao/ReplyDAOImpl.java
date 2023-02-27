package com.gyemoim.dao;

import com.gyemoim.domain.ReplyVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ReplyDAOImpl implements ReplyDAO{

  @Inject
  private SqlSession sqlSession;


  @Override
  public List<ReplyVO> reply(int bid) throws Exception {
    return sqlSession.selectList("ReplyMapper.reply", bid);
  }

}
