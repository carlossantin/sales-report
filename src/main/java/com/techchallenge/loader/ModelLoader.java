package com.techchallenge.loader;

import com.techchallenge.model.Salesman;
import com.techchallenge.model.Customer;
import com.techchallenge.model.Sale;
import com.techchallenge.model.SaleItem;
import com.techchallenge.model.ModelFactory;
import com.techchallenge.reader.FileData;
import com.techchallenge.reader.FileLineData;

import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Optional;

public class ModelLoader {

  private static final Integer SALESMAN_CPF_IDX = 0;
  private static final Integer SALESMAN_NAME_IDX = 1;
  private static final Integer SALESMAN_SALARY_IDX = 2;

  private static final Integer CUSTOMER_CNPJ_IDX = 0;
  private static final Integer CUSTOMER_NAME_IDX = 1;
  private static final Integer CUSTOMER_BUSINESS_AREA_IDX = 2;

  private static final Integer SALE_ID_IDX = 0;
  private static final Integer SALE_ITEMS_IDX = 1;
  private static final Integer SALE_SALESMAN_IDX = 2;

  public static List<Salesman> loadSalesman(FileData fileData) {
    List<Salesman> lstSalesman = new ArrayList<Salesman>();
    List<FileLineData> fileLineData = fileData.getData(FieldTypesEnum.SALESMAN.getCode());

    fileLineData.forEach( line -> {
      List<String> lineItem = line.getData();

      String cpf = lineItem.get(SALESMAN_CPF_IDX);
      String name = lineItem.get(SALESMAN_NAME_IDX);
      Float salary = Float.valueOf(lineItem.get(SALESMAN_SALARY_IDX));

      lstSalesman.add(ModelFactory.newSalesman(name, cpf, salary));
    });

    return lstSalesman;
  }

  public static List<Customer> loadCustomer(FileData fileData) {
    List<Customer> customers = new ArrayList<Customer>();
    List<FileLineData> fileLineData = fileData.getData(FieldTypesEnum.CUSTOMER.getCode());

    fileLineData.forEach( line -> {
      List<String> lineItem = line.getData();

      String cnpj = lineItem.get(CUSTOMER_CNPJ_IDX);
      String name = lineItem.get(CUSTOMER_NAME_IDX);
      String businessArea = lineItem.get(CUSTOMER_BUSINESS_AREA_IDX);

      customers.add(ModelFactory.newCustomer(name, cnpj, businessArea));
    });

    return customers;
  }

  public static List<Sale> loadSales(FileData fileData, List<Salesman> salesmanList) {
    List<Sale> sales = new ArrayList<Sale>();    
    List<FileLineData> fileLineData = fileData.getData(FieldTypesEnum.SALES.getCode());
    System.out.println(fileLineData.size());

    fileLineData.forEach( line -> {      
      List<String> lineItem = line.getData();

      Integer id = Integer.valueOf(lineItem.get(SALE_ID_IDX));
      String strItems = lineItem.get(SALE_ITEMS_IDX);
      String salesmanName = lineItem.get(SALE_SALESMAN_IDX);

      List<SaleItem> saleItems = convertStringToSaleItems(strItems);

      Salesman salesman = salesmanList.stream().filter(salesmanItem -> 
        salesmanName.equals(salesmanItem.getName())).findAny().get();

      sales.add(ModelFactory.newSale(id, saleItems, salesman));
    });

    return sales;
  }

  private static List<SaleItem> convertStringToSaleItems(String strSaleItems) {
    List<SaleItem> saleItems = new ArrayList<SaleItem>();

    strSaleItems = strSaleItems.replace("[", "");
    strSaleItems = strSaleItems.replace("]", "");
    
    final StringTokenizer tokenizer = new StringTokenizer(strSaleItems, ",");
    while (tokenizer.hasMoreTokens()) {
      String nextToken = tokenizer.nextToken();
      System.out.println(nextToken);
      final StringTokenizer fieldsTokenizer = new StringTokenizer(nextToken, "-");

      Optional<Integer> itemId = Optional.empty();
      Optional<Integer> itemQuantity = Optional.empty();
      Optional<Float> itemPrice = Optional.empty();

      int currentPos = 0;
      while (fieldsTokenizer.hasMoreTokens()) {
        switch (currentPos) {
          case 0: {
            itemId = Optional.of(Integer.valueOf(fieldsTokenizer.nextToken()));
            break;
          }
          case 1: {
            itemQuantity = Optional.of(Integer.valueOf(fieldsTokenizer.nextToken()));
            break;
          }
          case 2: {
            itemPrice = Optional.of(Float.valueOf(fieldsTokenizer.nextToken()));
            break;
          }
        }
        currentPos++;
      }

      saleItems.add(ModelFactory.newSaleItem(itemId.get(), itemQuantity.get(), itemPrice.get()));
    }

    return saleItems;
  }

}
