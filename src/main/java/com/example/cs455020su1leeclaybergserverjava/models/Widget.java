package com.example.cs455020su1leeclaybergserverjava.models;

public class Widget {
    private String name;
    private int id;
    private String topicId;
    private String type;
    private int widgetOrder;
    private String text;
    private String src;
    private int size;
    private int width;
    private int height;
    private String cssClass;
    private String style;
    private String value;

    public Widget(String name, int id, String topicId, String type, int widgetOrder, String text, String src, int size, int width, int height, String cssClass, String style, String value) {
        this.name = name;
        this.id = id;
        this.topicId = topicId;
        this.type = type;
        this.widgetOrder = widgetOrder;
        this.text = text;
        this.src = src;
        this.size = size;
        this.width = width;
        this.height = height;
        this.cssClass = cssClass;
        this.style = style;
        this.value = value;
    }

    public Widget(Widget newWidget) {
        this.name = newWidget.name;
        this.id = newWidget.id;
        this.topicId = newWidget.topicId;
        this.type = newWidget.type;
        this.widgetOrder = newWidget.widgetOrder;
        this.text = newWidget.text;
        this.src = newWidget.src;
        this.size = newWidget.size;
        this.width = newWidget.width;
        this.height = newWidget.height;
        this.cssClass = newWidget.cssClass;
        this.style = newWidget.style;
        this.value = newWidget.value;
    }

    public void updateWidget(Widget newWidget) {
        this.name = newWidget.name;
        this.id = newWidget.id;
        this.type = newWidget.type;
        this.widgetOrder = newWidget.widgetOrder;
        this.text = newWidget.text;
        this.src = newWidget.src;
        this.size = newWidget.size;
        this.width = newWidget.width;
        this.height = newWidget.height;
        this.cssClass = newWidget.cssClass;
        this.style = newWidget.style;
        this.value = newWidget.value;
    }

    public Widget() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWidgetOrder() {
        return widgetOrder;
    }

    public void setWidgetOrder(int widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
