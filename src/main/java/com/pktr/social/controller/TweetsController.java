package com.pktr.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pktr.social.model.TwitterModel;

@Controller
public class TweetsController {

  private static final String PKTR_HANDLE = "pradeepktr84";

  @Autowired
  private Twitter twitter;

  @RequestMapping("/")
  public String index(Model model) {
    TwitterModel twitterModel = new TwitterModel();
    twitterModel.setHandle(PKTR_HANDLE);
    model.addAttribute("twitterModel", twitterModel);
    return "hello";
  }

  @RequestMapping(value = "/favorites", method = RequestMethod.POST)
  public String retrieveFavorites(
      @ModelAttribute(value = "twitterModel") TwitterModel twitterModel, Model model) {
    List<org.springframework.social.twitter.api.Tweet> tweets = twitter.timelineOperations()
        .getFavorites(twitterModel.getHandle(), 50);
    model.addAttribute("tweetList", tweets);
    return "favorites";
  }

}
