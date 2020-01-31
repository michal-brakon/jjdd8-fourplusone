package com.infoshareacademy.service;

import com.infoshareacademy.dao.EpochDao;
import com.infoshareacademy.domain.entity.Epoch;
import com.infoshareacademy.domain.view.EpochView;
import com.infoshareacademy.mapper.view.EpochMapperToView;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class EpochService {

    @Inject
    private EpochDao epochDao;

    @Inject
    private EpochMapperToView epochMapperToView;

    public Epoch add(String name) {

        return Optional.ofNullable(epochDao.findEpochByName(name)).orElseGet(() -> {
            Epoch epoch = new Epoch();
            epoch.setName(name);
            epochDao.addEpoch(epoch);
            return epoch;
        });
    }

    public List<EpochView> getAll() {
        List<EpochView> epochViews = new ArrayList<>();
        epochDao.getAll().forEach(epoch -> {
            EpochView epochView = epochMapperToView.mapEntityToRequest(epoch);
            epochViews.add(epochView);
        });
        return epochViews;
    }
}
