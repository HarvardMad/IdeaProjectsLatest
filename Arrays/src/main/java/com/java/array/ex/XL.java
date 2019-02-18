package com.java.array.ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XL {


  public static void main(String[] args) {

    List<String> nameList = null,recordList=null ;
    String txtFileName = "/Users/LalinPethiyagoda/IdeaProjects/Arrays/src/main/resources/Book1.csv";
    String names = "/Users/LalinPethiyagoda/IdeaProjects/Arrays/src/main/resources/names.csv";

    try (Stream<String> stream = Files.lines(Paths.get(names))) {

      nameList =stream.map(str->str.substring(0,str.length()-1))
          .collect(Collectors.toList());
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    // reading csv file into stream, try-with-resources
    try (Stream<String> stream = Files.lines(Paths.get(txtFileName))) {
     recordList =stream
         .collect(Collectors.toList());

    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    Map<String,List<String>> namesAndRecords = new HashMap<>();
    List<String> listOfMatchingRecords=null;
    for(String name: nameList ){
      listOfMatchingRecords = new ArrayList<String>();
      for(String record:recordList){
        if(record.contains(name)){
          listOfMatchingRecords.add(record);
        }
      }
      namesAndRecords.put(name,listOfMatchingRecords);
    }

    namesAndRecords.size();
    fileWriter(namesAndRecords);

  }

public static void fileWriter(Map<String,List<String>> map){

  try (PrintWriter writer = new PrintWriter(new File("/Users/LalinPethiyagoda/IdeaProjects/Arrays/src/main/resources/test.csv"))) {

    StringBuilder sb = new StringBuilder();
    sb.append("name");
    sb.append(',');
    sb.append("record");
    sb.append('\n');

    for(String name: map.keySet()){
      for(String record:map.get(name)){
        sb.append(name);
        sb.append(',');
        sb.append(record);
        sb.append('\n');
      }
    }
    writer.write(sb.toString());
    System.out.println("done!");
  } catch (FileNotFoundException e) {
    System.out.println(e.getMessage());
  }

}

}
