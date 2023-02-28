package com.gyemoim.dao.board;

import com.gyemoim.domain.board.BoardVO;
import com.gyemoim.domain.board.PageVO;
import com.gyemoim.dto.board.BoardListDTO;

import java.util.List;

public interface BoardDAO {

  int countBoard();

  List<BoardVO> selectBoard(PageVO vo);

  BoardVO readDetail(int bid);

  List<BoardVO> searchList(BoardListDTO dto) throws Exception;

}
