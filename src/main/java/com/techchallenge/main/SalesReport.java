package com.techchallenge.main;

import com.techchallenge.watcher.SalesWatcherService;

import java.io.IOException;

public class SalesReport {

  public SalesReport() {
    try {
      final String inputDirectory = String.format("%s/data/in", System.getProperty("user.home"));
      final String outputDirectory = String.format("%s/data/out", System.getProperty("user.home"));
      final String fieldsDelimiter = "ç"; 

      final String[] extensionsToWatch = {"dat"};
      final SalesWatcherService watcher = new SalesWatcherService();
      watcher.watch(inputDirectory, fieldsDelimiter, outputDirectory, extensionsToWatch);

    } catch (InterruptedException | IOException e) {
       e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    new SalesReport();
  }
}
