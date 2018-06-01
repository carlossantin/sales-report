package com.techchallenge.writer;

import com.techchallenge.reader.FileData;
import com.techchallenge.model.Salesman;
import com.techchallenge.model.Customer;
import com.techchallenge.model.Sale;
import com.techchallenge.loader.ModelLoader;
import com.techchallenge.statistic.DataAnalyzer;

import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputWriter {

  public static void writeSummarizedData(FileData fileData, String outputDirectory, String fileName) throws IOException {
    final List<Salesman> lstSalesman = ModelLoader.loadSalesman(fileData);
    final List<Customer> lstCustomer = ModelLoader.loadCustomer(fileData);
    final List<Sale> lstSales = ModelLoader.loadSales(fileData, lstSalesman);

    final File outputDir = new File(outputDirectory);
    if (!outputDir.exists()) {
      outputDir.mkdirs();
    }

    final File outFile = new File(outputDirectory, fileName + ".done.dat");
    final FileWriter writer = new FileWriter(outFile);
    final String lineSeparator = System.getProperty("line.separator");

    writer.write(String.format("Customers amount: %d", DataAnalyzer.getCustomersAmount(lstCustomer)));
    writer.write(lineSeparator);
    writer.write(String.format("Salesman amount: %d", DataAnalyzer.getSalesmanAmount(lstSalesman)));
    writer.write(lineSeparator);
    writer.write(String.format("Most Expensive sale ID: %03d", DataAnalyzer.getMostExpensiveSaleId(lstSales)));
    writer.write(lineSeparator);
    writer.write(String.format("Worst salesman: %s", DataAnalyzer.getWorstSalesman(lstSales, lstSalesman).getName()));
    writer.close();

  }

}
