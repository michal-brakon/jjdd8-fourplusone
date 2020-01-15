package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.api.KindJson;
import com.infoshareacademy.domain.entity.LiteratureKind;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class KindMapper {

    public LiteratureKind mapApiRequestToEntity(KindJson kindJson) {

        LiteratureKind kind = new LiteratureKind();
        kind.setName(kindJson.getName());
        return kind;
    }
}
