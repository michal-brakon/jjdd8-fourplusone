package com.infoshareacademy.mapper;
import com.infoshareacademy.dao.BookDao;
import com.infoshareacademy.entity.Book;
import com.infoshareacademy.service.BookService;

import javax.inject.Inject;
import javax.swing.text.ComponentView;
import javax.swing.text.Element;

import javax.swing.text.View;
import javax.swing.text.html.ObjectView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookMapper {


    //Mapper natomiast maa dwie formy metod: mapRequestToEntity oraz mapEntityToView


    @Inject
    private BookService bookService;

    public View mapEntityToView(Long id) {
        return new ObjectView((Element) bookService.getById(id));}

        public List<String> fullBook (Long id) {

        List<String> nn = new ArrayList<>();

        Book book = bookService.getById(id);

            Stream.of(book)
            .forEach(t -> {
                nn.add(t.getTitle()),
                    nn.add(t.getCover()),
                    nn.add(t.getCoverThumb()),
                    nn.add(t.getSimpleThumb()),
                    nn.add(t.getAuthors().toString()),
                    nn.add(t.getEpochId().toString()),
                    nn.add(t.getGenres().toString()),
                    nn.add(t.getLiteratureKindId().toString()),
                    nn.add(t.getHasAudio().toString())
            });




        return nn;







//               if (id == null) {
//            return null;
//        }
//
//        return View (
//                "title", bookDao.getTitle(),
//                "author", book.getAuthors(),
//                "epoch", book.getEpochId(),
//                "cover", book.getCover(),
//                "simple_thumb", book.getSimpleThumb(),
//                "has_audio", book.getHasAudio(),
//                "cover_thumb", book.getCoverThumb(),
//                "genre", book.getGenres(),
//                "literature", book.getLiteratureKindId());
//
//    }

    }
}
