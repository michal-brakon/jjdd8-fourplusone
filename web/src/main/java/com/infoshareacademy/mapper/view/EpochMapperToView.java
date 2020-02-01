package com.infoshareacademy.mapper.view;

import com.infoshareacademy.domain.entity.Epoch;
import com.infoshareacademy.domain.entity.Genre;
import com.infoshareacademy.domain.view.EpochView;
import com.infoshareacademy.domain.view.GenreView;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class EpochMapperToView {

    public EpochView mapEntityToRequest(Epoch epoch) {
        EpochView epochView = new EpochView();
        epochView.setId(epoch.getId());
        epochView.setName(epoch.getName());
        return epochView;
    }
}
