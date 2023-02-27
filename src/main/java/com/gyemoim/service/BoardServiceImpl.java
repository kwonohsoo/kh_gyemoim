package com.gyemoim.service;

import com.gyemoim.dao.BoardDAO;
import com.gyemoim.domain.BoardVO;
import com.gyemoim.domain.PageVO;
import com.gyemoim.domain.ReplyVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

  @Inject
  private BoardDAO boardDAO;

  @Override
  public int countBoard() throws Exception {
    return boardDAO.countBoard();
  }

  @Override
  public List<BoardVO> selectBoard(PageVO vo) throws Exception {
    return boardDAO.selectBoard(vo);
  }

  @Override
  public BoardVO readDetail(int bid) {
    return boardDAO.readDetail(bid);
  }

}
