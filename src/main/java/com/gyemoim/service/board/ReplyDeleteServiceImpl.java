package com.gyemoim.service.board;

import com.gyemoim.dao.board.ReplyDeleteDAO;
import com.gyemoim.domain.board.ReplyVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
@Service
public class ReplyDeleteServiceImpl implements ReplyDeleteService{
    @Inject
    private ReplyDeleteDAO replyDeleteDAO;
    @Override
    public void replyDelete(ReplyVO vo) throws Exception {
        System.out.println("댓글삭제서비스" + vo);
        replyDeleteDAO.replyDelete(vo);
    }
}
