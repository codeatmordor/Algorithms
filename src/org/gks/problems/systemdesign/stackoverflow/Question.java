

// PACKAGE/IMPORTS --------------------------------------------------
package org.gks.problems.systemdesign.stackoverflow;

import java.util.Date;
import java.util.List;

public class Question implements Search {

  private String title;
  private String description;
  private int viewCount;
  private int voteCount;
  private Date creationTime;
  private Date updateTime;
  private QuestionStatus status;
  private QuestionClosingRemark closingRemark;

  private Member askingMember;
  private Bounty bounty;
  private List<Photo> photos;
  private List<Comment> comments;
  private List<Answer> answers;

  public boolean close();

  public boolean undelete();

  public boolean addComment(Comment comment);

  public boolean addBounty(Bounty bounty);

  @Override
  public List<Question> search(String query) {
    return null;
    // return all questions containing the string query in their title or description.
  }

}

