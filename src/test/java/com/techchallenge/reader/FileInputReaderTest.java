package com.techchallenge.reader;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.io.IOException;

import com.techchallenge.util.EntityData;
import com.techchallenge.util.IOHelper;

public class FileInputReaderTest {

  private FileData fileData;
  private String filePath;

  private final String fieldDelimiter = "ç";

  @Before
  public void setup() throws IOException {
    fileData = EntityData.getFileData();
    filePath = IOHelper.writeInputFile(fileData);
  }

  @Test
  public void testReadingInputData() throws IOException {
    FileData readFileData = FileInputReader.readFileData(filePath, fieldDelimiter);
    Assert.assertEquals(fileData, readFileData);
  }

}
