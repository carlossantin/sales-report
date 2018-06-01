package com.techchallenge.loader;

public enum FieldTypesEnum {
  SALESMAN("001"),
  CUSTOMER("002"),
  SALES("003");

  private final String code;

  FieldTypesEnum(String code) {
    this.code = code;
  }

  public String getCode() {
    return this.code;
  }
}
