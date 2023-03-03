package com.gyemoim.service.board;

import com.gyemoim.dao.board.BoardDeleteDAO;
import com.gyemoim.dto.board.BoardDeleteDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BoardDeleteServiceImpl implements BoardDeleteService{

  @Inject
  private BoardDeleteDAO boardDeleteDAO;

  @Override
  public void delete(BoardDeleteDTO dto) throws Exception {
    boardDeleteDAO.delete(dto);
  }
}
