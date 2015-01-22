package com.pktr.social.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pktr.social.model.Tweet;
import com.pktr.social.model.TwitterModel;

@Controller
public class TweetsController {

  @Autowired
  private Twitter twitter;

  @RequestMapping("/")
  public String index(Model model) {
    TwitterModel twitterModel = new TwitterModel();
    twitterModel.setHandle("pradeepktr84");
    model.addAttribute("twitterModel", twitterModel);
    return "hello";
  }
  
  @RequestMapping(value = "/favorites", method=RequestMethod.POST)
  public String retrieveFavorites(@ModelAttribute(value="twitterModel") TwitterModel twitterModel, Model model) {
    List<org.springframework.social.twitter.api.Tweet> tweets =  twitter.timelineOperations().getFavorites(twitterModel.getHandle(), 50);
    model.addAttribute("tweetList", transformTweets(tweets));
    model.addAttribute("mytweet", new Tweet());
    return "favorites";
  }
  
  private List<Tweet> transformTweets(List<org.springframework.social.twitter.api.Tweet> tweets) {
    List<Tweet> tweetList = new ArrayList<Tweet>(tweets.size());
    for (org.springframework.social.twitter.api.Tweet tweet : tweets) {
      Tweet mytweet = new Tweet();
      mytweet.setFromUser(tweet.getFromUser());
      mytweet.setText(tweet.getText());
      mytweet.setProfileImageURL(tweet.getProfileImageUrl());
      tweetList.add(mytweet);
    }
    return tweetList;
  }



}
