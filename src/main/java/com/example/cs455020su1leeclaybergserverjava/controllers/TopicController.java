package com.example.cs455020su1leeclaybergserverjava.controllers;

import com.example.cs455020su1leeclaybergserverjava.models.Topic;
import com.example.cs455020su1leeclaybergserverjava.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {
  @Autowired
  TopicService service;

  @GetMapping("/api/lessons/{lessonId}/topics")
  public Topic createTopic(@PathVariable("lessonId") String lessonId, @RequestBody Topic newTopic) {
    return service.createTopic(lessonId, newTopic);
  }

  @GetMapping("/api/topics/{topicId}")
  public int deleteTopic(@PathVariable("topicId") Integer tid) {
    return service.deleteTopic(tid);
  }

  @GetMapping("/api/topics/{topicId}")
  public int updateTopic(@PathVariable("topicId") Integer tid, @RequestBody Topic updatedTopic) {
    return service.updateTopic(tid, updatedTopic);
  }

  @GetMapping("/api/topics")
  public List<Topic> findAllTopics() {
    return service.findAllTopics();
  }

  @GetMapping("/api/topics/{topicId}")
  public Topic findTopicById(@PathVariable("topicId") Integer tid) {
    return service.findTopicById(tid);
  }

  @GetMapping("/api/lessons/{lessonId}/topics")
  public List<Topic> findTopicsForLesson(@PathVariable("lessonId") String lessonId) {
    return service.findTopicsForLesson(lessonId);
  }
}
