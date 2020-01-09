package com.infoshareacademy.mapper;

import com.infoshareacademy.dao.BookDao;

import javax.inject.Inject;
import javax.json.JsonObject;

public class BookMapper {

    @Inject
    private BookDao bookDao;


    public JsonObject toJson(Book book){
        return JsonHelper.toJson(
                

        )

    }

}
