package com.gyemoim.service.board;

import com.gyemoim.dao.board.BoardWriteDAO;
import com.gyemoim.dto.board.BoardWriteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.io.File;
import java.util.UUID;

@Service
public class BoardWriteServiceImpl implements BoardWriteService {
    @Inject
    private BoardWriteDAO boardWriteDAO;
    @Autowired
    private String uploadPath;
    String filePath = "/gyemoim/upload/";
    @Transactional
    @Override
    public void write(BoardWriteDTO dto) throws Exception {
        System.out.println("들어가랏 플리즈!" + dto);
        boardWriteDAO.write(dto);

        /* 첨부파일 */
        MultipartFile UploadFile = dto.getUploadFile();
        if(!UploadFile.isEmpty()) {
            UUID uid = UUID.randomUUID();
            String savedName = uid.toString() + "_" + UploadFile.getOriginalFilename();
            //savedName은 유니크네임
            UploadFile.transferTo(new File(uploadPath + filePath + savedName)); //서버에 파일 저장

            boardWriteDAO.addAttachedName(savedName);
            // return boardWriteDAO.write(dto);
        }
    }


}
