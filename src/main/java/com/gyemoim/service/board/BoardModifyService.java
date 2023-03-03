package com.gyemoim.service.board;

import com.gyemoim.domain.board.AttachedVO;
import com.gyemoim.domain.board.BoardVO;
import com.gyemoim.dto.board.BoardModifyDTO;
import com.gyemoim.dto.board.BoardWriteDTO;

public interface BoardModifyService {
    BoardVO modify(int bid) throws Exception;
    AttachedVO attached(int bid) throws Exception;
    AttachedVO deleteFile(String fileName) throws Exception;

    public void modifyUpdate(BoardModifyDTO dto) throws Exception;

}
