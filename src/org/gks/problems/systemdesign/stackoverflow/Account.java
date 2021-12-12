

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.stackoverflow;


public class Account {

  private String id;
  private String password;
  private AccountStatus status;
  private String name;
  private Address address;
  private String email;
  private String phone;
  private int reputation;

  public Account(String id) {
    this.id = id;
  }

  public boolean resetPassword() {
    return false;
  }

}

