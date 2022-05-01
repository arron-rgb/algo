package edu.neu.design;

import java.util.*;

/**
 * @author arronshentu
 */
public class FileSystem {
  private class Directory {
    Map<String, Directory> children = new HashMap<>();
    Map<String, String> files = new HashMap<>();
  }

  Directory root;

  public FileSystem() {
    root = new Directory();
  }

  public List<String> ls(String path) {
    Directory t = root;
    List<String> files = new ArrayList<>();
    if (!"/".equals(path)) {
      String[] d = path.split("/");
      for (int i = 1; i < d.length - 1; i++) {
        t = t.children.get(d[i]);
      }
      if (t.files.containsKey(d[d.length - 1])) {
        files.add(d[d.length - 1]);
        return files;
      } else {
        t = t.children.get(d[d.length - 1]);
      }
    }
    files.addAll(new ArrayList<>(t.children.keySet()));
    files.addAll(new ArrayList<>(t.files.keySet()));
    Collections.sort(files);
    return files;
  }

  public void mkdir(String path) {
    Directory t = root;
    String[] d = path.split("/");
    for (int i = 1; i < d.length; i++) {
      if (!t.children.containsKey(d[i])) {
        t.children.put(d[i], new Directory());
      }
      t = t.children.get(d[i]);
    }
  }

  public void addContentToFile(String filePath, String content) {
    Directory t = root;
    String[] d = filePath.split("/");
    for (int i = 1; i < d.length - 1; i++) {
      t = t.children.get(d[i]);
    }
    t.files.put(d[d.length - 1], t.files.getOrDefault(d[d.length - 1], "") + content);
  }

  public String readContentFromFile(String filePath) {
    Directory t = root;
    String[] d = filePath.split("/");
    for (int i = 1; i < d.length - 1; i++) {
      t = t.children.get(d[i]);
    }
    return t.files.get(d[d.length - 1]);
  }
}
