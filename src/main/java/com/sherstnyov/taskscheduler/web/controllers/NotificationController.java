package com.sherstnyov.taskscheduler.web.controllers;

import org.springframework.stereotype.Controller;

import java.util.Observable;
import java.util.Observer;

@Controller
public class NotificationController implements Observer {

    private String news;

    @Override
    public void update(Observable o, Object news) {
        this.setNews((String) news);
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    //Send notification to API
}
