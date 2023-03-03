package com.gyemoim.dao.board;

import com.gyemoim.dto.board.BoardWriteDTO;

public interface BoardWriteDAO {

    public void write(BoardWriteDTO dto) throws Exception;
    public void addAttachedName(String savedName) throws Exception;


}
