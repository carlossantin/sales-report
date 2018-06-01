package com.techchallenge.reader;

import java.util.List;
import java.util.ArrayList;

public class FileLineDataImpl implements FileLineData {
  
  private final List<String> lineData = new ArrayList<String>();

  public List<String> getData() {
    return this.lineData;
  }

  public void addData(String datum) {
    lineData.add(datum);
  }

  @Override
  public boolean equals(Object obj) {
    boolean equals = true;

    if (obj != null && obj instanceof FileLineDataImpl) {
      final List<String> objLineData = ((FileLineDataImpl)obj).getData();
      
      if (lineData.size() == objLineData.size()) {
        
        for (int i = 0; i < lineData.size(); i++) {
          equals = equals && (lineData.get(i).equals(objLineData.get(i)));
        }
      } else {
        equals = true;
      }
    } else {
      equals = false;
    }
    
    return equals;
  }

}
