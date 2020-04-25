package com.ff.entity;


public class GlobalParameterEntity {

  private Long id;
  private String parameterName;
  private String parameterValue;
  private String defaultValue;
  private String customOrNot;
  private String fileName;
  private String parameterFunction;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getParameterName() {
    return parameterName;
  }

  public void setParameterName(String parameterName) {
    this.parameterName = parameterName;
  }


  public String getParameterValue() {
    return parameterValue;
  }

  public void setParameterValue(String parameterValue) {
    this.parameterValue = parameterValue;
  }


  public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }


  public String getCustomOrNot() {
    return customOrNot;
  }

  public void setCustomOrNot(String customOrNot) {
    this.customOrNot = customOrNot;
  }


  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getParameterFunction() {
    return parameterFunction;
  }

  public void setParameterFunction(String parameterFunction) {
    this.parameterFunction = parameterFunction;
  }
}
