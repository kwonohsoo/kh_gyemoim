package com.gyemoim.service;

import com.gyemoim.dao.ReplyDAO;
import com.gyemoim.domain.ReplyVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{

  @Inject
  private ReplyDAO replyDAO;

  @Override
  public List<ReplyVO> reply(int bid) throws Exception {
    return replyDAO.reply(bid);
  }
}
