package com.infoshareacademy.service;


import com.infoshareacademy.dao.KindDao;
import com.infoshareacademy.domain.entity.LiteratureKind;
import com.infoshareacademy.domain.view.KindView;
import com.infoshareacademy.mapper.view.KindMapperToView;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class KindService {

    @EJB
    private KindDao kindDao;

    @Inject
    private KindMapperToView kindMapperToView;

    public LiteratureKind add(String name) {

        return Optional.ofNullable(kindDao.findKindByName(name)).orElseGet(() -> {
            LiteratureKind kind = new LiteratureKind();
            kind.setName(name);
            kindDao.addKind(kind);
            return kind;
        });
    }

    public List<KindView> getAll() {
        List<KindView> kindViews = new ArrayList<>();
        kindDao.getAll().forEach(kind -> {
            KindView kindView = kindMapperToView.mapEntityToRequest(kind);
            kindViews.add(kindView);
        });
        return kindViews;
    }
}
