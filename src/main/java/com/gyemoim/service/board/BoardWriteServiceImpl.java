package com.gyemoim.service.board;

import com.gyemoim.dao.board.BoardWriteDAO;
import com.gyemoim.dto.board.BoardWriteDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.io.File;
import java.util.UUID;

@Service
public class BoardWriteServiceImpl implements BoardWriteService {
    @Inject
    private BoardWriteDAO boardWriteDAO;
    @Transactional
    @Override
    public void write(BoardWriteDTO dto) throws Exception {
        System.out.println("들어가랏 플리즈!" + dto);
        boardWriteDAO.write(dto);

        /* 첨부파일 */
        MultipartFile UploadFile = dto.getUploadFile();
        UUID uid = UUID.randomUUID();
        String savedName = uid.toString() +"_"+ UploadFile.getOriginalFilename();
        UploadFile.transferTo(new File("C:\\gyemoim\\upload\\" + savedName));
        if(UploadFile == null) { return; }
        boardWriteDAO.addAttach(savedName);
       // return boardWriteDAO.write(dto);
    }

}
