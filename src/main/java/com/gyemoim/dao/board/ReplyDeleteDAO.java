package com.gyemoim.dao.board;

import com.gyemoim.domain.board.ReplyVO;

public interface ReplyDeleteDAO {
  //댓글작성
  void replyDelete(ReplyVO vo) throws Exception;

}
