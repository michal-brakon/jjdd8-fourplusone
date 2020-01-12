package com.infoshareacademy.mapper;

import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.entity.Book;
import com.infoshareacademy.util.JsonHelper;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.swing.text.View;

public class BookMapper {


    //Mapper natomiast maa dwie formy metod: mapRequestToEntity oraz mapEntityToView

    @Inject
    private BookDao bookDao;

    public View toView(Long id){

        if (id == null) {
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
