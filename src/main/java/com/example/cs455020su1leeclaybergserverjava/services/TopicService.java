package com.example.cs455020su1leeclaybergserverjava.services;

import com.example.cs455020su1leeclaybergserverjava.models.Topic;
import com.example.cs455020su1leeclaybergserverjava.repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
  @Autowired
  TopicRepository repository;

  public Topic createTopic(String lid, Topic topic) {
    topic.setLesson(lid);
    return repository.save(topic);
  }

  public List<Topic> findTopicsForLesson(String lessonId) {
    return repository.findTopicsForLesson(lessonId);
  }

  public int updateTopic(int tid, Topic topic) {
    Topic existingTopic = repository.findTopicById(tid);
    existingTopic.updateTopic(topic);
    if(repository.save(existingTopic) == null) {
      return 0;
    }
    return 1;
  }

  public int deleteTopic(int tid) {
    repository.deleteById(tid);
    if(repository.findTopicById(tid) != null) {
      return 0;
    }
    return 1;
  }

  public List<Topic> findAllTopics() {
    return repository.findAllTopics();
  }

  public Topic findTopicById(int tid) {
    return repository.findTopicById(tid);
  }
}
