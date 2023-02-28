package com.gyemoim.service.board;

import com.gyemoim.dao.board.BoardWriteDAO;
import com.gyemoim.dto.board.BoardWriteDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
@Service
public class BoardModifyServiceImpl implements BoardModifyService{
    @Inject
    private BoardWriteDAO boardWriteDAO;
    @Override
    public void modify(BoardWriteDTO dto) throws Exception {
        System.out.println("애플파이!" + dto);
        boardWriteDAO.modify(dto);
    }
}
