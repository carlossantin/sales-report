package com.techchallenge.model;

class CustomerImpl extends LegalPersonImpl implements Customer {

  private String businessArea;

  public CustomerImpl(String name, String cnpj, String businessArea) {
    super(name, cnpj);
    this.setBusinessArea(businessArea);
  }

  @Override
  public String getBusinessArea() {
    return this.businessArea;
  }

  @Override
  public void setBusinessArea(String businessArea) {
    this.businessArea = businessArea;
  }
  
}
