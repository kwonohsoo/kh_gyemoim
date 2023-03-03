package com.gyemoim.dto.board;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

//화면에서 받는 데이터
@Data
@ToString
public class BoardDeleteDTO {
  private Long uNo;
  private int bid;

}
