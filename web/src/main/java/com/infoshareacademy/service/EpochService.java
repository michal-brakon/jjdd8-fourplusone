package com.infoshareacademy.service;

import com.infoshareacademy.dao.EpochDao;
import com.infoshareacademy.domain.entity.Epoch;

import javax.inject.Inject;

public class EpochService {

    @Inject
    private EpochDao epochDao;

    public Epoch findOrAdd(String name)  {

        Epoch epoch = epochDao.findEpochByName(name);
        if (epoch == null)  {
            Epoch newEpoch = new Epoch();
            epochDao.addEpoch(newEpoch);
            return newEpoch;
        }
        return epoch;
    }
}
