package com.gyemoim.service;

import com.gyemoim.domain.ReplyVO;

import java.util.List;

public interface ReplyService {

  List<ReplyVO> reply(int bid) throws Exception;
}
