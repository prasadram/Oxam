// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.beans.data;

/**
 * 
 * @author aksharaaaa Get the User data.
 *
 */
public class User {
  // private String userName;
  private String studentName;
  private int age;
  private String gender;

  /*
   * public String getUserName() { return userName; } public void setUserName(String userName) {
   * this.userName = userName; }
   */
  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

}
