package com.gyemoim.dao.board;

import com.gyemoim.domain.board.BoardVO;
import com.gyemoim.domain.board.PageVO;

import java.util.List;

public interface BoardDAO {

  int countBoard();

  int searchCountBoard(PageVO spv);

  List<BoardVO> selectBoard(PageVO vo);

  BoardVO readDetail(int bid);

  List<BoardVO> searchList(PageVO spv) throws Exception;

}
