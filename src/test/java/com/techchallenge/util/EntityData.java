package com.techchallenge.util;

import com.techchallenge.reader.FileData;
import com.techchallenge.reader.FileLineData;
import com.techchallenge.reader.FileLineDataImpl;
import com.techchallenge.loader.FieldTypesEnum;
import com.techchallenge.model.Salesman;
import com.techchallenge.model.Customer;
import com.techchallenge.model.Sale;
import com.techchallenge.model.SaleItem;
import com.techchallenge.model.ModelFactory;

import java.util.List;
import java.util.ArrayList;

public class EntityData {

  public static List<Salesman> getSalesmanData() {
    List<Salesman> salesmen = new ArrayList<Salesman>();    
    salesmen.add(ModelFactory.newSalesman("1234567891234", "Diego", 50000f));
    salesmen.add(ModelFactory.newSalesman("3245678865434", "Renato", 40000.99f));
    return salesmen;
  }

  public static List<Customer> getCustomerData() {
    List<Customer> customers = new ArrayList<Customer>();    
    customers.add(ModelFactory.newCustomer("2345675434544345", "Jose da Silva", "Rural"));
    customers.add(ModelFactory.newCustomer("2345675433444345", "Eduardo Pereira", "Rural"));
    return customers;
  }

  public static List<Sale> getSalesData() {
    List<Sale> sales = new ArrayList<Sale>();
    List<SaleItem> saleItems = new ArrayList<SaleItem>();
    saleItems.add(ModelFactory.newSaleItem(1, 10, 100f));
    saleItems.add(ModelFactory.newSaleItem(2, 30, 2.50f));
    saleItems.add(ModelFactory.newSaleItem(3, 40, 3.10f));
    sales.add(ModelFactory.newSale(10, saleItems, ModelFactory.newSalesman("1234567891234", "Diego", 50000f)));

    saleItems = new ArrayList<SaleItem>();
    saleItems.add(ModelFactory.newSaleItem(1, 34, 10f));
    saleItems.add(ModelFactory.newSaleItem(2, 33, 1.50f));
    saleItems.add(ModelFactory.newSaleItem(3, 40, 0.10f));
    sales.add(ModelFactory.newSale(8, saleItems, ModelFactory.newSalesman("3245678865434", "Renato", 40000.99f)));
    
    return sales;
  }

  public static FileData getFileData() {
    FileData fileData = new FileData();
    
    getSalesmanData().forEach( salesman -> {
      FileLineData fileLineData = new FileLineDataImpl();
      fileLineData.addData(salesman.getCpf());
      fileLineData.addData(salesman.getName());
      fileLineData.addData(String.valueOf(salesman.getSalary()));
      fileData.addFileLineData(FieldTypesEnum.SALESMAN.getCode(), fileLineData);
    });

    getCustomerData().forEach( customer -> {
      FileLineData fileLineData = new FileLineDataImpl();
      fileLineData.addData(customer.getCnpj());
      fileLineData.addData(customer.getName());
      fileLineData.addData(customer.getBusinessArea());
      fileData.addFileLineData(FieldTypesEnum.CUSTOMER.getCode(), fileLineData);
    });

    getSalesData().forEach( sale -> {
      FileLineData fileLineData = new FileLineDataImpl();
      fileLineData.addData(String.format("%02d", sale.getId()));
      StringBuilder items = new StringBuilder("[");

      List<String> saleItems = new ArrayList<String>();
      sale.getItems().forEach( item -> {
        saleItems.add(item.toString());
      });

      items.append(String.join(",", saleItems));
      items.append("]");
      System.out.println(items.toString());
      fileLineData.addData(items.toString());
      fileLineData.addData(sale.getSalesman().getName());
      fileData.addFileLineData(FieldTypesEnum.SALES.getCode(), fileLineData);
    });

    return fileData;
  }

}
