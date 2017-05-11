// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.beans.data;

/**
 * @author aksharaaaa Get the Student class.
 *
 */
public class Student {
  private int stundentId;
  // private String studentName;
  private String firstName;
  private String lastName;
  private String gender;
  private String emailId;
  private Department deparmentId;

  public Department getDeparmentId() {
    return deparmentId;
  }

  public void setDeparmentId(Department deparmentId) {
    this.deparmentId = deparmentId;
  }

  public int getStundentId() {
    return stundentId;
  }

  public void setStundentId(int stundentId) {
    this.stundentId = stundentId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

}
