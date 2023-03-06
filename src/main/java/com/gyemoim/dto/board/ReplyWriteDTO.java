package com.gyemoim.dto.board;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

//화면에서 받는 데이터
@Data
@ToString
public class ReplyWriteDTO {
    private int bid;
    private Integer uNo;
    private String name;
    private Date repDate;
    private String comm;

}
