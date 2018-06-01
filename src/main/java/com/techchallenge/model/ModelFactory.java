package com.techchallenge.model;

import java.util.List;

public class ModelFactory {

  public static Customer newCustomer(String name, String cnpj, String businessArea) {
    return new CustomerImpl(name, cnpj, businessArea);
  }

  public static Salesman newSalesman(String name, String cpf, Float salary) {
    return new SalesmanImpl(name, cpf, salary);
  }

  public static Sale newSale(Integer id, List<SaleItem> items, Salesman salesman) {
    return new SaleImpl(id, items, salesman);
  }

  public static SaleItem newSaleItem(Integer id, Integer quantity, Float price) {
    return new SaleItemImpl(id, quantity, price);
  }

}
