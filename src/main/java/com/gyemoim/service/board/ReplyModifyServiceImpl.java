package com.gyemoim.service.board;

import com.gyemoim.dao.board.ReplyModifyDAO;
import com.gyemoim.domain.board.ReplyVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ReplyModifyServiceImpl implements  ReplyModifyService {

    @Inject
    private ReplyModifyDAO replyModifyDAO;

    @Override
    public void replyModify(ReplyVO vo) throws Exception {
        System.out.println("댓글수정서비스" + vo);
        replyModifyDAO.replyModify(vo);
    }
}
