package com.gyemoim.dao;

import com.gyemoim.domain.BoardVO;
import com.gyemoim.domain.PageVO;
import com.gyemoim.domain.ReplyVO;

import java.util.List;

public interface BoardDAO {

  int countBoard();

  List<BoardVO> selectBoard(PageVO vo);

  BoardVO readDetail(int bid);

}
