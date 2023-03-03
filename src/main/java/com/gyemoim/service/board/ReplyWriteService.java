package com.gyemoim.service.board;

import com.gyemoim.domain.board.ReplyVO;
import com.gyemoim.dto.board.ReplyWriteDTO;

import java.util.List;

public interface ReplyWriteService {


  //댓글 작성
  void replyWrite(ReplyVO vo) throws Exception;

//댓글 조회
  List<ReplyVO> reply(int bid) throws Exception;


}
