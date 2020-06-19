package com.example.cs455020su1leeclaybergserverjava.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="topics")
public class Topic {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String title;
  private String description;
  @OneToMany(mappedBy = "topic")
  private List<Widget> widgets;
  private String lessonId;

  public Topic(int id, String title, String description, List<Widget> widgets, String lessonId) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.widgets = widgets;
    this.lessonId = lessonId;
  }

  public Topic() {
  }

  public void updateTopic(Topic topic) {
    this.title = topic.title;
    this.description = topic.description;
    this.widgets = topic.widgets;
    this.lessonId = topic.lessonId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Widget> getWidgets() {
    return widgets;
  }

  public void setWidgets(List<Widget> widgets) {
    this.widgets = widgets;
  }

  public String getLessonId() {
    return lessonId;
  }

  public void setLessonId(String lessonId) {
    this.lessonId = lessonId;
  }
}
