package com.techchallenge.reader;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.util.List;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileInputReaderTest {

  private FileData fileData;
  private String filePath;
  private final String fieldDelimiter = "ç";
  private final String lineSeparator = System.getProperty("line.separator");

  @Before
  public void setup() throws IOException {
    loadFileData();
    filePath = writeInputFile();
  }

  @Test
  public void testReadingInputData() throws IOException {
    FileData readFileData = FileInputReader.readFileData(filePath, fieldDelimiter);
    Assert.assertEquals(fileData, readFileData);
  }

  private void loadFileData() {
    fileData = new FileData();
    
    FileLineData fileLineData = new FileLineDataImpl();
    fileLineData.addData("1234567891234");
    fileLineData.addData("Diego");
    fileLineData.addData("50000");
    fileData.addFileLineData("001", fileLineData);

    fileLineData = new FileLineDataImpl();
    fileLineData.addData("3245678865434");
    fileLineData.addData("Renato");
    fileLineData.addData("40000.99");
    fileData.addFileLineData("001", fileLineData);

    fileLineData = new FileLineDataImpl();
    fileLineData.addData("2345675434544345");
    fileLineData.addData("Jose da Silva");
    fileLineData.addData("Rural");
    fileData.addFileLineData("002", fileLineData);

    fileLineData = new FileLineDataImpl();
    fileLineData.addData("2345675433444345");
    fileLineData.addData("Eduardo Pereira");
    fileLineData.addData("Rural");
    fileData.addFileLineData("002", fileLineData);

    fileLineData = new FileLineDataImpl();
    fileLineData.addData("10");
    fileLineData.addData("[1-10-100,2-30-2.50,3-40-3.10]");
    fileLineData.addData("Diego");
    fileData.addFileLineData("003", fileLineData);

    fileLineData = new FileLineDataImpl();
    fileLineData.addData("08");
    fileLineData.addData("[1-34-10,2-33-1.50,3-40-0.10]");
    fileLineData.addData("Renato");
    fileData.addFileLineData("003", fileLineData);
  }

  private String writeInputFile() throws IOException {
    File tmpFile = File.createTempFile("test", ".dat");
    FileWriter writer = new FileWriter(tmpFile);

    List<FileLineData> salesmanData = fileData.getData("001");
    this.writeFieldData("001", salesmanData, writer);
    List<FileLineData> customerData = fileData.getData("002");
    this.writeFieldData("002", customerData, writer);
    List<FileLineData> salesData = fileData.getData("003");
    this.writeFieldData("003", salesData, writer);
    writer.close();

    return tmpFile.getPath();
  }

  private void writeFieldData(String fieldId, List<FileLineData> fieldData, FileWriter writer) {
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
