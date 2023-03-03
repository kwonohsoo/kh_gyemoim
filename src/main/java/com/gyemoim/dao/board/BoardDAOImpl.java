package com.gyemoim.dao.board;

import com.gyemoim.domain.board.BoardVO;
import com.gyemoim.domain.board.PageVO;
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
  public int searchCountBoard(PageVO spv) {
    return sqlSession.selectOne("BoardMapper.searchCountBoard", spv);
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
  public List<BoardVO> searchList(PageVO spv) throws Exception {
    System.out.println("sear dao");
    return sqlSession.selectList("BoardListMapper.selectSearchList", spv);
  }

}
