package com.ff.entity;


public class SystemPictureManagementEntity {

  private long id;
  private String fileName;
  private String filePath;
  private String pictureFunction;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }


  public String getPictureFunction() {
    return pictureFunction;
  }

  public void setPictureFunction(String pictureFunction) {
    this.pictureFunction = pictureFunction;
  }

}
