package com.gyemoim.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardVO {

  private int bid;
  private long uNo;
  private String type;
  private String name;
  private String title;
  private int views;
  private String content;
  private Date writeDate;
  private char secret;


}
