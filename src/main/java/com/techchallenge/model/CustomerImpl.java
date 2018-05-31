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

  @Override
  public boolean equals(Object obj) {
    boolean equals = super.equals(obj);    

    if (obj != null && obj instanceof Customer) {
      Customer objCustomer = (Customer)obj;
      equals = equals && (this.businessArea.equals(objCustomer.getBusinessArea()));
    } else {
      equals = false;
    }
    
    return equals;
  }
  
}
