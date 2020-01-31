package com.infoshareacademy.mapper.view;

import com.infoshareacademy.domain.entity.LiteratureKind;
import com.infoshareacademy.domain.view.KindView;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class KindMapperToView {

    @Inject
    private KindView kindView;

    public KindView mapEntityToRequest(LiteratureKind kind) {
        KindView kindView = new KindView();

        kindView.setId(kind.getId());
        kindView.setName(kind.getName());

        return kindView;
    }

}
