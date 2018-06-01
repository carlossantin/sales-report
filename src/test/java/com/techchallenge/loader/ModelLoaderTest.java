package com.techchallenge.loader;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import com.techchallenge.util.EntityData;
import com.techchallenge.reader.FileData;
import com.techchallenge.model.Salesman;
import com.techchallenge.model.Customer;
import com.techchallenge.model.Sale;

import java.util.List;

public class ModelLoaderTest {

  private FileData fileData;
  private List<Salesman> salesmanData;
  private List<Customer> customerData;
  private List<Sale> salesData;

  @Before
  public void setup() {
    fileData = EntityData.getFileData();
    salesmanData = EntityData.getSalesmanData();
    customerData = EntityData.getCustomerData();
    salesData = EntityData.getSalesData();
  }
  
  @Test
  public void testSalesmanLoader() {
    List<Salesman> salesman = ModelLoader.loadSalesman(fileData);
    Assert.assertEquals(salesmanData.size(), salesman.size());

    for (int i = 0; i < salesmanData.size(); i++) {
      Assert.assertEquals(salesmanData.get(i), salesman.get(i));
    }
  }

  @Test
  public void testCustomerLoader() {
    List<Customer> customers = ModelLoader.loadCustomer(fileData);
    Assert.assertEquals(customerData.size(), customers.size());

    for (int i = 0; i < customerData.size(); i++) {
      Assert.assertEquals(customerData.get(i), customers.get(i));
    }
  }

  @Test
  public void testSaleLoader() {

    List<Sale> sales = ModelLoader.loadSales(fileData, salesmanData);
    Assert.assertEquals(salesData.size(), sales.size());

    for (int i = 0; i < salesData.size(); i++) {
      Assert.assertEquals(salesData.get(i), sales.get(i));
    }
  }

}
