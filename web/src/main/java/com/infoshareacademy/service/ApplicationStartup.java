package com.infoshareacademy.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class ApplicationStartup {

    @Inject
    private HandlerService handlerService;

    @PostConstruct
    protected void initDatabase() {
        handlerService.setApi();
    }

}
