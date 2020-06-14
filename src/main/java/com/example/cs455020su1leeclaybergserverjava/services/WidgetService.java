package com.example.cs455020su1leeclaybergserverjava.services;

import com.example.cs455020su1leeclaybergserverjava.models.Widget;

import java.util.ArrayList;
import java.util.List;

public class WidgetService {
  List<Widget> widgets = new ArrayList<>();

  public Widget createWidget(String tid, Widget widget) {
    Widget newWidget = new Widget(widget);
    newWidget.setTopicId(tid);
    widgets.add(newWidget);
    return newWidget;
  }

  public List<Widget> findWidgetsForTopic(String tid) {
    
  }

  public int updateWidget(int wid, Widget widget) {
    for (Widget w: widgets) {
      if(w.getId() == wid) {
        w.updateWidget(widget);
        return 1;
      }
    }
    return 0;
  }

  public int deleteWidget(int wid) {
    for (Widget w: widgets) {
      if(w.getId() == wid) {
        widgets.remove(w);
        return 1;
      }
    }
    return 0;
  }

  public List<Widget> findAllWidgets(){
    return widgets;
  }

  public Widget findWidgetById(int wid) {
    for (Widget w: widgets) {
      if(w.getId() == wid) {
        return w;
      }
    }
    return null;
  }
}
