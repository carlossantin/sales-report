package com.techchallenge.model;

abstract class PersonImpl implements Person {

  private String name;

  public PersonImpl(String name) {
    this.setName(name);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

}
