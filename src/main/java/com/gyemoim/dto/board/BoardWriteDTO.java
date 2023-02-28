package com.gyemoim.dto.board;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

//화면에서 받는 데이터
@Data
@ToString
public class BoardWriteDTO {
    private String name;
    private String title;
    private String content;
    private char secret;
    private MultipartFile uploadFile;

}
