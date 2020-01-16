package com.infoshareacademy.service;

import com.infoshareacademy.dao.EpochDao;
import com.infoshareacademy.domain.entity.Epoch;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EpochService {

    @Inject
    private EpochDao epochDao;

    public Epoch findOrAdd(String name)  {

        Epoch epoch = epochDao.findEpochByName(name);
        if (epoch == null)  {
            Epoch newEpoch = new Epoch();
            newEpoch.setName(name);
            epochDao.addEpoch(newEpoch);
            return newEpoch;
        }
        return epoch;
    }
}
