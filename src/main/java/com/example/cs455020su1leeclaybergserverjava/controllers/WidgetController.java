package com.example.cs455020su1leeclaybergserverjava.controllers;

import com.example.cs455020su1leeclaybergserverjava.models.Widget;
import com.example.cs455020su1leeclaybergserverjava.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

  @Autowired
  WidgetService service;

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidget(@PathVariable("tid") Integer topicId, @RequestBody Widget newWidget) {
    return service.createWidget(topicId, newWidget);
  }

  @GetMapping("/api/topics/{topicId}/widgets")
  public List<Widget> findWidgetsForTopic(@PathVariable("topicId") Integer tid) {
    return service.findWidgetsForTopic(tid);
  }

  @PutMapping("/api/widgets/{wid}")
  public int updateWidget(@PathVariable("wid") Integer widgetId, @RequestBody Widget updatedWidget) {
    return service.updateWidget(widgetId, updatedWidget);
  }

  @DeleteMapping("/api/widgets/{widgetId}")
  public int deleteWidget(@PathVariable("widgetId") Integer wid) {
    return service.deleteWidget(wid);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{widgetId}")
  public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
    return service.findWidgetById(wid);
  }
}
