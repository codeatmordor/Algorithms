

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.stackoverflow;

import java.util.List;

public class Member {

  private Account account;
  private List<Badge> badges;

  public int getReputation();

  public String getEmail();

  public boolean createQuestion(Question question);

  public boolean createTag(Tag tag);

}

