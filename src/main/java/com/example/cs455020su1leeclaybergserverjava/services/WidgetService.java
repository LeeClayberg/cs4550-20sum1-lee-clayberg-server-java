package com.example.cs455020su1leeclaybergserverjava.services;

import com.example.cs455020su1leeclaybergserverjava.models.Topic;
import com.example.cs455020su1leeclaybergserverjava.models.Widget;
import com.example.cs455020su1leeclaybergserverjava.repositories.TopicRepository;
import com.example.cs455020su1leeclaybergserverjava.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetService {

  @Autowired
  TopicRepository topicRepository;

  @Autowired
  WidgetRepository repository;

  public List<Widget> findWidgetsForTopic(Integer tid) {
    return repository.findWidgetsForTopic(tid);
  }

  public Widget findWidgetById(Integer wid) {
    return repository.findWidgetById(wid);
  }

  public List<Widget> findAllWidgets() {
    return repository.findAllWidgets();
  }

  public int deleteWidget(Integer wid) {
    repository.deleteById(wid);
    if(repository.findWidgetById(wid) != null) {
      return 0;
    }
    return 1;
  }

  public Widget createWidget(Integer tid, Widget newWidget) {
    Topic topic = topicRepository.findTopicById(tid);
    newWidget.setTopic(topic);
    return repository.save(newWidget);
  }

  public int updateWidget(Integer widgetId, Widget updatedWidget) {
    Widget widget = repository.findWidgetById(widgetId);
    widget.updateWidget(updatedWidget);
    if(repository.save(widget) == null) {
      return 0;
    }
    return 1;
  }
}
