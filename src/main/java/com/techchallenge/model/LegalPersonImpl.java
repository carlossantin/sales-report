package com.techchallenge.model;

abstract class LegalPersonImpl extends PersonImpl implements LegalPerson {

  private String cnpj;

  public LegalPersonImpl(String name, String cnpj) {
    super(name);
    this.setCnpj(cnpj);
  }

  @Override
  public String getCnpj() {
    return this.cnpj;
  }

  @Override
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

}
