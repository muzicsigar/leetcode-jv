package com.maverickbyte.algo.leetcode;

import java.util.LinkedList;

/**
 * @author Alan Li
 * @since 1.0
 */
public class N0071M_SimplifyPath {
  public String simplifyPath(String path) {
    LinkedList<String> deque = new LinkedList<>();
    String[] tokens = path.split("/");
    for (String token : tokens) {
      if (token.isEmpty() || token.equals(".")) {
        continue;
      }
      if (token.equals("..")) {
        if (!deque.isEmpty()) {
          deque.pop();
        }
        continue;
      }
      deque.push(token);
    }
    if (deque.isEmpty()) {
      return "/";
    }
    StringBuilder sb = new StringBuilder();
    while (!deque.isEmpty()) {
      sb.append("/").append(deque.pollLast());
    }
    return sb.toString();
  }

  public String simplifyPath1(String path) {
    if (null == path || path.length() == 0) {
      return null;
    }
    if (path.length() == 1) {
      return "/";
    }
    LinkedList<String> tokens = new LinkedList<>();
    int startSlash = 0;
    int i = 0;
    while (i < path.length()) {
      if (path.charAt(i) == '/' && startSlash != i) {
        tokens.add(path.substring(startSlash, i).substring(1));
        startSlash = i;
      }
      i++;
    }
    if (startSlash + 1 != i) {
      tokens.add(path.substring(startSlash, i).substring(1));
    }

    LinkedList<String> deque = new LinkedList<>();
    for (int k = 0; k < tokens.size(); k++) {
      String token = tokens.get(k);
      if (!token.equals("") && !token.equals(".") && !token.equals("..")) {
        deque.addLast(token);
        continue;
      }
      if (token.equals("..") && tokens.size() > 0) {
        deque.pollLast();
        continue;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int k = 0; k < deque.size(); k++) {
      sb.append("/").append(deque.get(k));
    }
    if (sb.length() == 0) {
      sb.append("/");
    }
    return sb.toString();
  }

  public String simplifyPath2(String path) {
    if (null == path || path.length() == 0) {
      return null;
    }
    if (path.length() == 1) {
      return "/";
    }
    int startSlash = 0;
    LinkedList<String> tokens = new LinkedList<>();
    int i = 0;
    while (i < path.length()) {
      if (path.charAt(i) == '/' && startSlash != i) {
        String token = path.substring(startSlash, i).substring(1);
        // add
        if (!token.equals("..") && !token.equals("") && !token.equals(".")) {
          tokens.addLast(token);
        }
        // or delete
        if (token.equals("..") && tokens.size() > 0) {
          tokens.pollLast();
        }
        // or drop
        startSlash = i;
      }
      i++;
    }
    if (startSlash + 1 != i) {
      String token = path.substring(startSlash, i).substring(1);
      // add
      if (!token.equals("..") && !token.equals("") && !token.equals(".")) {
        tokens.addLast(token);
      }
      // or delete
      if (token.equals("..") && tokens.size() > 0) {
        tokens.pollLast();
      }
      // or drop
    }

    StringBuilder sb = new StringBuilder();
    for (int k = 0; k < tokens.size(); k++) {
      sb.append("/").append(tokens.get(k));
    }
    if (sb.length() == 0) {
      sb.append("/");
    }
    return sb.toString();
  }

  // test case: /home/.../ab
  // test case: /...      ...代表一个文件名 = = ！
  // test case: /../
  // test case: /a//b////c/d//././/..
  public static void main(String[] args) {
    N0071M_SimplifyPath runner = new N0071M_SimplifyPath();
    System.out.println(runner.simplifyPath2("/home/.../ab")); // expect: /..., WHY!!!!!
    System.out.println(runner.simplifyPath2("/...")); // expect: /..., WHY!!!!!
    System.out.println(runner.simplifyPath2("/../")); // expect: /
    System.out.println(runner.simplifyPath2("/a//b////c/d//././/.."));// expect: /a/b/c
  }

  public String simplifyPath3(String path) {
    int len = path.length();
    LinkedList<String> s = new LinkedList<>();

    for (int i = 0; i < len; i++) {
      if (path.charAt(i) != '/') {
        int nextIndex = path.indexOf('/', i);
        String filename = nextIndex == -1 ? path.substring(i) : path.substring(i, nextIndex);
        if (filename.equals("..")) {
          if (!s.isEmpty()) {
            s.poll();
          }
        } else if (!filename.equals(".")) {
          s.addFirst(filename);
        }
        i = nextIndex;
        if (i == -1) {
          break;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!s.isEmpty()) {
      sb.append("/").append(s.removeLast());
    }
    String res = sb.toString();
    return res.equals("") ? "/" : res;
  }

}
