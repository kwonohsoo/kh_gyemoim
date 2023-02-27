package com.gyemoim.dao.board;

import com.gyemoim.domain.board.ReplyVO;

import java.util.List;

public interface ReplyDAO {

  List<ReplyVO> reply(int bid) throws Exception;
}
