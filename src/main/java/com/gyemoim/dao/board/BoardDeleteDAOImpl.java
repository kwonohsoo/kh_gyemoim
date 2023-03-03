package com.gyemoim.dao.board;

import com.gyemoim.dto.board.BoardDeleteDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class BoardDeleteDAOImpl implements BoardDeleteDAO {

  @Inject
  private SqlSession sqlSession;

  @Override
  public void delete(BoardDeleteDTO dto) throws Exception {
    sqlSession.delete("BoardDeleteMapper.delete", dto);
  }
}
