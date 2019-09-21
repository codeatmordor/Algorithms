

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.logisticsystem;


public class User {

  private int userId;
  private String name;
  private Location adress;
  private String mobNo;
  private String emailId;

  /**
   * @return the userId
   */
  public int getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(int userId) {
    this.userId = userId;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the adress
   */
  public Location getAdress() {
    return adress;
  }

  /**
   * @param adress the adress to set
   */
  public void setAdress(Location adress) {
    this.adress = adress;
  }

  /**
   * @return the mobNo
   */
  public String getMobNo() {
    return mobNo;
  }

  /**
   * @param mobNo the mobNo to set
   */
  public void setMobNo(String mobNo) {
    this.mobNo = mobNo;
  }

  /**
   * @return the emailId
   */
  public String getEmailId() {
    return emailId;
  }

  /**
   * @param emailId the emailId to set
   */
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

}

