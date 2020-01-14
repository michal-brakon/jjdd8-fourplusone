package com.infoshareacademy.mapper.view;

        import com.infoshareacademy.domain.entity.Book;
        import com.infoshareacademy.domain.view.*;
        import com.infoshareacademy.service.BookService;

        import javax.inject.Inject;

public class BookMapper {

    //Mapper natomiast maa dwie formy metod: mapRequestToEntity oraz mapEntityToView

    @Inject
    private BookService bookService;

    @Inject
    private AuthorView authorView;

    @Inject
    private EpochView epochView;

    @Inject
    private GenreView genreView;

    @Inject
    private KindView kindView;


    public BookView mapEntityToView(Book book) {

        BookView view = new BookView();

        view.setAudio(book.getHasAudio());
        view.setCover(book.getCover());
        view.setTitle(book.getTitle());
        view.setAuthor(authorView.getName());
        view.setEpoch(epochView.getName());
        view.setGenre(genreView.getName());
        view.setKind(kindView.getName());

        return view;

    }
}
