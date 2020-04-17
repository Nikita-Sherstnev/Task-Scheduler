package com.sherstnyov.taskscheduler.services;

import org.springframework.stereotype.Service;

import java.util.Observable;

@Service
public class NotificationService extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
        System.out.println(news);
    }


}
