package com.techchallenge.model;

public interface SaleItem {

  public Integer getId();
  public Integer getQuantity();
  public Float getPrice();

  public void setId(Integer id);
  public void setQuantity(Integer quantity);
  public void setPrice(Float price);

  public Float getTotalValue();

}
