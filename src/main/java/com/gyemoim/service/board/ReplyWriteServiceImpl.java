package com.gyemoim.service.board;

import com.gyemoim.dao.board.ReplyWriteDAO;
import com.gyemoim.domain.board.ReplyVO;
import com.gyemoim.dto.board.ReplyWriteDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ReplyWriteServiceImpl implements ReplyWriteService{

  @Inject
  private ReplyWriteDAO replyWriteDAO;

  //댓글 작성
  @Override
  public void replyWrite(ReplyVO vo) throws Exception {
    System.out.println("댓글작성서비스" + vo);
    replyWriteDAO.replyWrite(vo);
  }

  //댓글 조회
  @Override
  public List<ReplyVO> reply(int bid) throws Exception {
    return replyWriteDAO.reply(bid);
  }
}
