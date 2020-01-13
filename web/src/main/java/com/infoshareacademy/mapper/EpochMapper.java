package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.api.EpochJson;
import com.infoshareacademy.domain.entity.Epoch;

import javax.ejb.Stateless;

@Stateless
public class EpochMapper {

    public Epoch mapApiRequestToEntity(EpochJson epochJson) {

        Epoch epoch = new Epoch();
        epoch.setName(epochJson.getName());
        return epoch;
    }
}
