package com.techchallenge.model;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.util.List;
import java.util.ArrayList;

public class ModelFactoryTest {

  private List<SaleItem> emptySaleItemsList;
  private List<SaleItem> saleItemList;

  @Before
  public void setup() {
    emptySaleItemsList = new ArrayList();
    saleItemList = new ArrayList();
    saleItemList.add(ModelFactory.newSaleItem(100, 30, 40.50f));
  }

  @Test
  public void testNullSaleItemsParameterConvertedToEmptyList() {
    final Sale sale = ModelFactory.newSale(1, null, null);
    Assert.assertEquals(emptySaleItemsList, sale.getItems());
  }

  @Test
  public void testNotNullSaleItemsParameter() {
    final Sale sale = ModelFactory.newSale(1, saleItemList, null);
    Assert.assertEquals(saleItemList, sale.getItems());
  }
}
