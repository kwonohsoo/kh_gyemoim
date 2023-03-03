package com.gyemoim.service.board;

import com.gyemoim.dao.board.BoardDAO;
import com.gyemoim.domain.board.BoardVO;
import com.gyemoim.domain.board.PageVO;
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
  public int searchCountBoard(PageVO spv) throws Exception {
    return boardDAO.searchCountBoard(spv);
  }

  @Override
  public List<BoardVO> selectBoard(PageVO vo) throws Exception {
    return boardDAO.selectBoard(vo);
  }

  @Override
  public BoardVO readDetail(int bid) {
    return boardDAO.readDetail(bid);
  }

  @Override
  public List<BoardVO> searchList(PageVO spv) throws Exception {
    System.out.println("search service");
    return boardDAO.searchList(spv);
  }

}
