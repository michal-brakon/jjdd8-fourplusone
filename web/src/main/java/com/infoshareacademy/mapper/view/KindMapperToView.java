package com.infoshareacademy.mapper.view;

import com.infoshareacademy.domain.entity.LiteratureKind;
import com.infoshareacademy.domain.view.KindView;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class KindMapperToView {

    public KindView mapEntityToRequest(LiteratureKind kind) {
           KindView kindView = new KindView();
           kindView.setId(kind.getId());
           kindView.setName(kind.getName());
           return kindView;
       }

}
