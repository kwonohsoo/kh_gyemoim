package com.gyemoim.service.board;

import com.gyemoim.dao.board.BoardModifyDAO;
import com.gyemoim.dao.board.BoardWriteDAO;
import com.gyemoim.domain.board.AttachedVO;
import com.gyemoim.domain.board.BoardVO;
import com.gyemoim.dto.board.BoardModifyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


@Service
public class BoardModifyServiceImpl implements BoardModifyService{
    @Inject
    private BoardModifyDAO boardModifyDAO;
    @Inject
    private BoardWriteDAO boardWriteDAO;
    @Autowired
    private String uploadPath;
    String filePath = "/gyemoim/upload/";
    //수정페이지 불러오기
    @Override
    public BoardVO modify(int bid) throws Exception {
        return boardModifyDAO.modify(bid);
    }
    //수정페이지 첨부파일 불러오기
    @Override
    public AttachedVO attached(int bid) throws Exception {
        return boardModifyDAO.attached(bid);
    }

    //old 첨부파일 삭제
    @Override
    public AttachedVO deleteFile(String fileName) throws Exception {
        try {
            Path file = Paths.get(uploadPath + filePath + fileName);
            Files.deleteIfExists(file);
        } catch(Exception e) {
            System.out.println("비상 에러발생!");
        }
        return null;
    }


    //수정하기
    @Override
    public void modifyUpdate(BoardModifyDTO dto) throws Exception {
        /*글 수정하기*/
        boardModifyDAO.modifyUpdate(dto);

        /* 첨부파일 */
        MultipartFile newFile = dto.getUploadFile();
        String oldFile;

        if(!newFile.isEmpty()) {
            UUID uid = UUID.randomUUID();
            String savedName = uid.toString() + "_" + newFile.getOriginalFilename();
            //savedName은 유니크네임
            newFile.transferTo(new File(uploadPath + filePath + savedName)); //서버에 파일 저장

        /* new 첨부파일 추가 */
            boardWriteDAO.addAttachedName(savedName);
        }

    }
}
