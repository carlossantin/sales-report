package com.techchallenge.statistic;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import com.techchallenge.util.EntityData;
import com.techchallenge.model.Sale;
import com.techchallenge.model.Customer;
import com.techchallenge.model.Salesman;

import java.util.List;

public class DataAnalyzerTest {

  private List<Salesman> salesmanData;
  private List<Customer> customerData;
  private List<Sale> salesData;

  private Integer salesmanAmount;
  private Integer customerAmount;
  private Salesman worstSalesman;
  private Integer mostExpensiveSaleId;

  @Before
  public void setup() {
    salesmanData = EntityData.getSalesmanData();
    customerData = EntityData.getCustomerData();
    salesData = EntityData.getSalesData();

    salesmanAmount = salesmanData.size();
    customerAmount = customerData.size();
    worstSalesman = EntityData.getWorstSalesman();
    mostExpensiveSaleId = EntityData.getMostExpensiveSaleId();
  }

  @Test
  public void testGettingSalesmanAmount() {
    Assert.assertEquals(salesmanAmount, DataAnalyzer.getSalesmanAmount(salesmanData));
  }

  @Test
  public void testGettingCustomerAmount() {
    Assert.assertEquals(customerAmount, DataAnalyzer.getCustomersAmount(customerData));
  }

  @Test
  public void testGettingWorstSalesman() {
    Assert.assertEquals(worstSalesman, DataAnalyzer.getWorstSalesman(salesData, salesmanData));
  }

  @Test
  public void testGettingMostExpensiveSaleId() {
    Assert.assertEquals(mostExpensiveSaleId, DataAnalyzer.getMostExpensiveSaleId(salesData));
  }

}
