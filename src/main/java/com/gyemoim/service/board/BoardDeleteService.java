package com.gyemoim.service.board;

import com.gyemoim.dto.board.BoardDeleteDTO;
import org.springframework.stereotype.Service;

@Service
public interface BoardDeleteService {

  void delete(BoardDeleteDTO dto) throws Exception;
}
