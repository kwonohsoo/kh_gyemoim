package com.gyemoim.domain.board;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyVO {

  private int bid;
  private Long uNo;
  private String name;
  private Date repDate;
  private String comm;
}
