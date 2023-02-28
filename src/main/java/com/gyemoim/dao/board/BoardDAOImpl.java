package com.gyemoim.dao.board;

import com.gyemoim.domain.board.BoardVO;
import com.gyemoim.domain.board.PageVO;
import com.gyemoim.dto.board.BoardListDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDAO{

  @Inject
  private SqlSession sqlSession;

  @Override
  public int countBoard() {
    return sqlSession.selectOne("BoardMapper.countBoard");
  }

  @Override
  public List<BoardVO> selectBoard(PageVO vo) {
    return sqlSession.selectList("BoardMapper.selectBoard", vo);
  }

  @Override
  public BoardVO readDetail(int bid) {
    return sqlSession.selectOne("BoardMapper.readDetail", bid);
  }

  @Override
  public List<BoardVO> searchList(BoardListDTO dto) throws Exception {
    return sqlSession.selectList("BoardListMapper.selectSearchList", dto);
  }

}
