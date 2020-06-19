package com.example.cs455020su1leeclaybergserverjava.repositories;

import com.example.cs455020su1leeclaybergserverjava.models.Topic;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

  @Query("SELECT topic FROM Topic topic")
  public List<Topic> findAllTopics();

  @Query("SELECT topic FROM Topic topic WHERE topic.id=:topicId")
  public Topic findTopicById(
          @Param("topicId") Integer tid);

  @Query("SELECT topic FROM Topic topic WHERE topic.lesson = :lessonId")
  public List<Topic> findTopicsForLesson(
          @Param("lessonId") String lessonId);
}
