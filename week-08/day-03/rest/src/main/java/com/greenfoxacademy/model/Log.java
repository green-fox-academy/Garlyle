package com.greenfoxacademy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Log {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  @Temporal(TemporalType.TIMESTAMP)
  Date createdAt;
  String endPoint;
  String jsondata;

  public Log(String endPoint, String data) {
    createdAt = new Date();
    this.endPoint = endPoint;
    this.jsondata = data;
  }

}
