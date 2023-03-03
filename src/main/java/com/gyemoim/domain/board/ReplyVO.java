package com.gyemoim.domain.board;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyVO {

  private int rno;
  private int bid;
  private Integer uno;
  private String name;
  private Date repDate;
  private String comm;
}
