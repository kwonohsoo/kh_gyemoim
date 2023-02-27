package com.gyemoim.service;

import com.gyemoim.domain.BoardVO;
import com.gyemoim.domain.PageVO;
import com.gyemoim.domain.ReplyVO;

import java.util.List;

public interface BoardService {

  int countBoard() throws Exception;

  List<BoardVO> selectBoard(PageVO vo) throws Exception;

  BoardVO readDetail(int bid);

}
