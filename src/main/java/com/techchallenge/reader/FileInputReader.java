package com.techchallenge.reader;

import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.util.Optional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileInputReader {

  public static FileData readFileData(String filePath, String fieldDelimiter) throws IOException {
    final FileData inputData = new FileData();

    final FileReader fileReader = new FileReader(filePath);
    final BufferedReader buffReader = new BufferedReader(fileReader);
    
    String line;
    while ((line = buffReader.readLine()) != null) {
      final StringTokenizer tokenizer = new StringTokenizer(line, fieldDelimiter);
      
      final FileLineData currentLineData = new FileLineDataImpl();
      Optional<String> fieldId = Optional.empty();

      while (tokenizer.hasMoreTokens()) {
        String nextToken = tokenizer.nextToken();
        //Read the first field, the field ID
        if (!fieldId.isPresent()) {
          fieldId = Optional.of(nextToken);
        } else {
          currentLineData.addData(nextToken);
        }
      }      
      inputData.addFileLineData(fieldId.get(), currentLineData);
    }

    return inputData;
  }

}
