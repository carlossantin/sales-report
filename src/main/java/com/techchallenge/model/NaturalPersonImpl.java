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

  @Override
  public boolean equals(Object obj) {
    boolean equals = super.equals(obj);

    if (obj != null && obj instanceof NaturalPerson) {
      NaturalPerson objPerson = (NaturalPerson)obj;
      equals = equals && (this.cpf.equals(objPerson.getCpf()));
    } else {
      equals = false;
    }
    
    return equals;
  }

}
