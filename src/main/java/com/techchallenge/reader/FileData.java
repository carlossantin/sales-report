package com.techchallenge.reader;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class FileData {

  private Map<String, List<FileLineData>> data;

  public FileData() {
    data = new HashMap<String, List<FileLineData>>();
  }

  public void addFileLineData(String fieldId, FileLineData lineData) {
    List<FileLineData> fieldData = this.getData(fieldId);
    fieldData.add(lineData);
    data.put(fieldId, fieldData);
  }

  public List<FileLineData> getData(String fieldId) {
    return Optional.ofNullable(data.get(fieldId)).orElse(new ArrayList<FileLineData>());
  }

  @Override
  public boolean equals(Object obj) {
    boolean equals = true;

    if (obj != null && obj instanceof FileData) {
      FileData objFileData = (FileData)obj;
      
      for (String key: data.keySet()) {
        List<FileLineData> lstFileLineData = data.get(key);
        List<FileLineData> lstObjFileLineData = objFileData.getData(key);

        if (lstFileLineData.size() == lstObjFileLineData.size()) {
          for (int i = 0; i < lstFileLineData.size(); i++) {
            equals = equals && (lstFileLineData.get(i).equals(lstObjFileLineData.get(i)));
          }
        } else {
          equals = false;
        }
      }
    } else {
      equals = false;
    }
    return equals;
  }

}
