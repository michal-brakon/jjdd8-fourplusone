package com.infoshareacademy.mapper;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.entity.Book;
import com.infoshareacademy.util.JsonHelper;

import javax.inject.Inject;
import javax.json.JsonObject;

public class BookMapper {

    @Inject
    private BookDao bookDao;


    public JsonObject toJson(Book book){

        if (book == null) {
            return null;
        }

        return JsonHelper.toJson(
                "title", book.getTitle(),
                "author", book.getAuthors(),
                "epoch", book.getEpochId(),
                "cover", book.getCover(),
                "simple_thumb", book.getSimpleThumb(),
                "has_audio", book.getHasAudio(),
                "cover_thumb", book.getCoverThumb(),
                "genre", book.getGenres(),
                "literature", book.getLiteratureKindId());


    }

}
