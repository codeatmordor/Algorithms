

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.InMemoryFS;


public class File extends Entry {

  private String content;
  private int size;

  public File(String n, Directory p, int sz) {
    super(n, p);
    size = sz;
  }

  @Override
  public int size() {
    return size;
  }

  public String getContents() {
    return content;
  }

  public void setContents(String c) {
    content = c;
  }

}

