package com.hhkbdev.asyncexceldownload.domain;

public class Field {

  Long id;
  String fieldName;
  String fieldType;
  String fieldComment;

  public Field(Long id, String fieldName, String fieldType, String fieldComment) {
    this.id = id;
    this.fieldName = fieldName;
    this.fieldType = fieldType;
    this.fieldComment = fieldComment;
  }

  public Long getId() {
    return id;
  }

  public String getFieldName() {
    return fieldName;
  }

  public String getFieldType() {
    return fieldType;
  }

  public String getFieldComment() {
    return fieldComment;
  }
}
