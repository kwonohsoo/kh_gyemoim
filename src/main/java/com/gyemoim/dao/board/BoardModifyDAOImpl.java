package com.gyemoim.dao.board;

import com.gyemoim.domain.board.AttachedVO;
import com.gyemoim.domain.board.BoardVO;
import com.gyemoim.dto.board.BoardModifyDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;


@Repository
public class BoardModifyDAOImpl implements BoardModifyDAO{
  @Inject
  private SqlSession sqlSession;
  private static String namespace = "com.gyemoim.dao.board.BoardModifyDAO";

  /* 원래 정보 끌고오기 */
  @Override
  public BoardVO modify(int bid) {
    return sqlSession.selectOne("BoardModifyMapper.modify", bid);
  }
  /* 첨부파일 끌고오기 */
  @Override
  public AttachedVO attached(int bid) {
    return sqlSession.selectOne("BoardModifyMapper.attached", bid);
  }
  /* 정보 업데이트 */
  @Override
  public void modifyUpdate(BoardModifyDTO dto) throws Exception {
    sqlSession.update(namespace + "BoardModifyMapper.update", dto);
  }

}
