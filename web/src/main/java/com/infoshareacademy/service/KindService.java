package com.infoshareacademy.service;


import com.infoshareacademy.dao.KindDao;
import com.infoshareacademy.domain.entity.LiteratureKind;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Optional;

@Stateless
public class KindService {

    @EJB
    private KindDao kindDao;

    public LiteratureKind add(String name) {

        return Optional.ofNullable(kindDao.findKindByName(name)).orElseGet(() -> {
            LiteratureKind kind = new LiteratureKind();
            kind.setName(name);
            kindDao.addKind(kind);
            return kind;
        });
    }
}
