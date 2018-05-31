package com.techchallenge.statistic;

import java.util.Optional;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.techchallenge.model.Salesman;
import com.techchallenge.model.Sale;
import com.techchallenge.model.Customer;

public class DataAnalyzer {

  public static Integer getCustomersAmount(List<Customer> customers) {
    return customers.size();
  }

  public static Integer getSalesmanAmount(List<Salesman> lstSalesman) {
    return lstSalesman.size();
  }

  public static Integer getMostExpensiveSaleId(List<Sale> sales) {
    Float mostExpensiveValue = 0f;
    Integer mostExpensiveId = -1;

    for(Sale sale: sales) {
      if (sale.getTotalValue() >= mostExpensiveValue) {
        mostExpensiveValue = sale.getTotalValue();
        mostExpensiveId = sale.getId();
      }
    }

    return mostExpensiveId;
  }

  public static Salesman getWorstSalesman(List<Sale> sales, List<Salesman> lstSalesman) {
    final Map<Salesman, Float> salesmanSales = new HashMap<Salesman, Float>();
    lstSalesman.forEach( salesman -> {
      salesmanSales.put(salesman, 0f);
    });

    sales.forEach( sale -> {
      Salesman salesman = sale.getSalesman();
      System.out.println(salesman.getName());
      Float saleValue = Optional.ofNullable(sale.getTotalValue()).orElse(0f);
      System.out.println(saleValue);
      Float lastValue = Optional.ofNullable(salesmanSales.get(salesman)).orElse(0f);
      System.out.println(lastValue);
      lastValue += saleValue;
      
      salesmanSales.put(salesman, lastValue);
    });

    Map<Salesman, Float> sortedMap = salesmanSales.entrySet().stream()
                  .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    System.out.println(sortedMap);

    return sortedMap.entrySet().iterator().next().getKey();
  }

}
