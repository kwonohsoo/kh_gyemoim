package com.gyemoim.service.board;

import com.gyemoim.domain.board.BoardVO;
import com.gyemoim.domain.board.PageVO;
import com.gyemoim.dto.board.BoardListDTO;

import java.util.List;

public interface BoardService {

  int countBoard() throws Exception;

  List<BoardVO> selectBoard(PageVO vo) throws Exception;

  BoardVO readDetail(int bid);

  List<BoardVO> searchList(BoardListDTO dto) throws Exception;

}
