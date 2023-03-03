package com.gyemoim.dao.board;

import com.gyemoim.dto.board.BoardDeleteDTO;

public interface BoardDeleteDAO {

  void delete(BoardDeleteDTO dto) throws Exception;
}
