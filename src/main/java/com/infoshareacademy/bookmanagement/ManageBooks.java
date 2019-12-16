package com.infoshareacademy.bookmanagement;

import com.infoshareacademy.Book;
import com.infoshareacademy.BookRepository;

public class ManageBooks {
    private  Long id = 1L;
    private BookRepository instance = BookRepository.getInstance();

    public void setId() {
        for (Book book : instance.getBooks()) {
            if(book.getId()==null){
            book.setId(getId());
            id++;}
        }
    }
    private Long getId() {
            return id;
    }
    private void setCurrentId(Long currentId){
        id=currentId;
    }
    public void getLastIdNumber(){
        instance.getBooks().forEach(i -> {
            if (i.getId() > getId()){ setCurrentId(i.getId());}
        } );
    }
}

