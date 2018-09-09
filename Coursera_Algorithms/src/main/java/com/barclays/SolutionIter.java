package com.barclays;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolutionIter implements Iterable<Integer> {

  private Reader reader;
  private List<Integer> numList = new ArrayList<>();

  public SolutionIter(Reader inp) throws IOException {
    reader = inp;
    int line=0;
    while (reader.ready()) {
      try{
        line = reader.read();
        int numOnline = Integer.parseInt(String.valueOf(line));
        numList.add(numOnline);

      }catch (NumberFormatException ex) {
        throw new NumberFormatException();
      }

    }

  }

  @Override
  public Iterator<Integer> iterator() {

    return new  IntIterator(reader);
  }

  class IntIterator implements Iterator<Integer>
  {
    Reader reader;
    IntIterator(Reader myReader) { reader = myReader; };
    @Override
    public boolean hasNext() {
      boolean isready=false;
      try {
        isready = reader.ready();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return isready;
    };
    @Override
    public Integer next() {
      Integer nextLine=0;
      try {
        nextLine = reader.read();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return nextLine;
    };
    @Override
    public void remove()
    { throw new UnsupportedOperationException("Remove not supported!"); };
  }

/*
 return new Iterator<Integer>(){

    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public Integer next() {
      return null;
    }
  };*/
}
