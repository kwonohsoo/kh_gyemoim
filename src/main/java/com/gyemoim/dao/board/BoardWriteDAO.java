package com.gyemoim.dao.board;

import com.gyemoim.dto.board.BoardWriteDTO;

public interface BoardWriteDAO {
    //public void write();
    //List<BoardWriteDAO> write() throws Exception;
    public void write(BoardWriteDTO dto) throws Exception;
    public void addAttach(String fullName) throws Exception;

    /*수정페이지*/
    public void modify(BoardWriteDTO dto) throws Exception;

}
