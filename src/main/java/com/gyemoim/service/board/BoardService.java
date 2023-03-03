package com.gyemoim.service.board;

import com.gyemoim.domain.board.BoardVO;
import com.gyemoim.domain.board.PageVO;

import java.util.List;

public interface BoardService {

  int countBoard() throws Exception;

  int searchCountBoard(PageVO spv) throws Exception;

  List<BoardVO> selectBoard(PageVO vo) throws Exception;

  BoardVO readDetail(int bid);

  List<BoardVO> searchList(PageVO spv) throws Exception;

}
