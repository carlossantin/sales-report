package com.techchallenge.model;

import java.util.List;

public interface Sale {

  public Integer getId();
  public List<SaleItem> getItems();
  public Salesman getSalesman();

  public void setId(Integer id);
  public void addItem(SaleItem item);
  public void setSalesman(Salesman salesman);

  public Float getTotalValue();

}
