package com.techchallenge.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

class SaleImpl implements Sale {

  private Integer id;
  private List<SaleItem> items;
  private Salesman salesman;

  public SaleImpl(Integer id, List<SaleItem> items, Salesman salesman) {
    this.id = id;
    this.items = Optional.ofNullable(items).orElse(new ArrayList<SaleItem>());
    this.salesman = salesman;
  }

  @Override
  public Integer getId() {
    return this.id;
  }

  @Override
  public List<SaleItem> getItems() {
    return this.items;
  }

  @Override
  public Salesman getSalesman() {
    return this.salesman;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public void addItem(SaleItem item) {
    this.items.add(item);
  }

  @Override
  public void setSalesman(Salesman salesman) {
    this.salesman = salesman;
  }

  @Override
  public boolean equals(Object obj) {
    boolean equals = true;

    if (obj != null && obj instanceof Sale) {    
      Sale objSale = (Sale)obj;
      equals = equals && (this.id.equals(objSale.getId())) &&
                (this.items.size() == objSale.getItems().size()) &&
                (this.items.equals(objSale.getItems())) &&
                (this.salesman.equals(objSale.getSalesman()));
    } else {
      equals = false;
    }

    return equals;
  }

}
