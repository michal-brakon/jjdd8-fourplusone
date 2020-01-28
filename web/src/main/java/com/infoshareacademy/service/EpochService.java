package com.infoshareacademy.service;

import com.infoshareacademy.dao.EpochDao;
import com.infoshareacademy.domain.entity.Epoch;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Optional;

@Stateless
public class EpochService {

    @Inject
    private EpochDao epochDao;

    public Epoch add(String name) {

        return Optional.ofNullable(epochDao.findEpochByName(name)).orElseGet(() -> {
            Epoch epoch = new Epoch();
            epoch.setName(name);
            epochDao.addEpoch(epoch);
            return epoch;
        });
    }
}
