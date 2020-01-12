package com.infoshareacademy.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class StartupBean {

    @Inject
    private SaveToDBService saveToDBService;

    @PostConstruct
    protected void initDatabase() {
        saveToDBService.setApi();
    }

}
