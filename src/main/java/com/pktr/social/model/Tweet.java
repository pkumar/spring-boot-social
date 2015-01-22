package com.pktr.social.model;

public class Tweet {

  private String text;
  
  private String fromUser;
  
  private String profileImageURL;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getFromUser() {
    return fromUser;
  }

  public void setFromUser(String fromUser) {
    this.fromUser = fromUser;
  }

  public String getProfileImageURL() {
    return profileImageURL;
  }

  public void setProfileImageURL(String profileImageURL) {
    this.profileImageURL = profileImageURL;
  }
  
  
}
