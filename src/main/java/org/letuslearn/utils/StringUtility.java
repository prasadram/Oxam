// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.utils;

import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author aksharaaaa Concatites the Strings
 *
 */
public class StringUtility {
  public StringBuffer getCommaSepratedList(List<String> list) {
    StringBuffer appendingColumnsWithCommaSeperated = new StringBuffer("");

    Iterator<String> iterator = list.iterator();

    while (iterator.hasNext()) {

      appendingColumnsWithCommaSeperated.append(iterator.next()).append(",");

    }

    return appendingColumnsWithCommaSeperated;
  }

  public StringBuffer removeLastChar(StringBuffer sb) {
    sb.deleteCharAt(sb.length() - 1);
    return sb;
  }

  public String replaceAtLastChar(StringBuffer sb, String string) {

    sb.replace(sb.length() - 1, sb.length(), string);
    return sb.toString();
  }
}
