package com.gyemoim.dao;

import com.gyemoim.domain.ReplyVO;

import java.util.List;

public interface ReplyDAO {

  List<ReplyVO> reply(int bid) throws Exception;
}
