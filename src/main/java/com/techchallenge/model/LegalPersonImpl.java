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

   @Override
  public boolean equals(Object obj) {
    boolean equals = super.equals(obj);

    if (obj != null && obj instanceof LegalPerson) {
      LegalPerson objPerson = (LegalPerson)obj;
      equals = equals && (this.cnpj.equals(objPerson.getCnpj()));
    } else {
      equals = false;
    }
    
    return equals;
  }

  @Override
  public int hashCode(){
    int prime = 37;
    int result = super.hashCode();
    result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
    return result;
  }

}
