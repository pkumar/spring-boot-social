package com.pktr.social;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetsController {
  
  @Autowired
  private Twitter twitter;
  
  @RequestMapping("/{handle}/favorites")
  public List<Tweet> hello(@PathVariable("handle") String handle) {
    
    return twitter.timelineOperations().getFavorites(handle, 50);
  }

}
