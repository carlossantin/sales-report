package com.techchallenge.model;

abstract class NaturalPersonImpl extends PersonImpl implements NaturalPerson {

  private String cpf;

  public NaturalPersonImpl(String name, String cpf) {
    super(name);
    this.setCpf(cpf);
  }

  @Override
  public String getCpf() {
    return this.cpf;
  }

  @Override
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

}
