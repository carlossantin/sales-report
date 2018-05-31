package com.techchallenge.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.techchallenge.reader.FileData;
import com.techchallenge.reader.FileLineData;
import com.techchallenge.loader.FieldTypesEnum;

import java.util.List;

public class IOHelper {

  private static final String fieldDelimiter = "ç";
  private static final String lineSeparator = System.getProperty("line.separator");

  public static String writeInputFile(FileData fileData) throws IOException {
    File tmpFile = File.createTempFile("test", ".dat");
    FileWriter writer = new FileWriter(tmpFile);

    List<FileLineData> salesmanData = fileData.getData(FieldTypesEnum.SALESMAN.getCode());
    writeFieldData(FieldTypesEnum.SALESMAN.getCode(), salesmanData, writer);
    List<FileLineData> customerData = fileData.getData(FieldTypesEnum.CUSTOMER.getCode());
    writeFieldData(FieldTypesEnum.CUSTOMER.getCode(), customerData, writer);
    List<FileLineData> salesData = fileData.getData(FieldTypesEnum.SALES.getCode());
    writeFieldData(FieldTypesEnum.SALES.getCode(), salesData, writer);
    writer.close();

    return tmpFile.getPath();
  }

  private static void writeFieldData(String fieldId, List<FileLineData> fieldData, FileWriter writer) {
    if (!fieldData.isEmpty()) {

      fieldData.forEach(lineData -> {
        try {
          writer.write(fieldId);
          lineData.getData().forEach(lineItem -> {
            try { 
              writer.write(fieldDelimiter);
              writer.write(lineItem);
            } catch (IOException e) {
              e.printStackTrace();
            }
          });
          
          writer.write(lineSeparator);
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      });
    }
  }

}
