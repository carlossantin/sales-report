package com.techchallenge.model;

class SaleItemImpl implements SaleItem {

  private Integer id;
  private Integer quantity;
  private Float price;

  public SaleItemImpl(Integer id, Integer quantity, Float price) {
    this.setId(id);
    this.setQuantity(quantity);
    this.setPrice(price);
  }

  @Override
  public Integer getId() {
    return this.id;
  }

  @Override
  public Integer getQuantity() {
    return this.quantity;
  }

  @Override
  public Float getPrice() {
    return this.price;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public void setPrice(Float price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return String.format(java.util.Locale.US, "%d-%d-%.2f", this.getId(), this.getQuantity(), this.getPrice());
  }

  @Override
  public boolean equals(Object obj) {
    boolean equals = true;

    if (obj != null && obj instanceof SaleItem) {    
      SaleItem objSaleItem = (SaleItem)obj;
      equals = equals && (this.id.equals(objSaleItem.getId())) &&
                (this.quantity.equals(objSaleItem.getQuantity())) &&
                (this.price.equals(objSaleItem.getPrice()));
    } else {
      equals = false;
    }

    return equals;
  }


}
