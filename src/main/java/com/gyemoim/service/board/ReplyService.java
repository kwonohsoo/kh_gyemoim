package com.gyemoim.service.board;

import com.gyemoim.domain.board.ReplyVO;

import java.util.List;

public interface ReplyService {

  List<ReplyVO> reply(int bid) throws Exception;
}
