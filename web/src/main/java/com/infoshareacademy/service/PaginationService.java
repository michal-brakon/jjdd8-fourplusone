package com.infoshareacademy.service;

import javax.ejb.Stateless;

@Stateless
public class PaginationService {

    public int add(int num) {
        return num + 20;
    }

    public int reduce(int num) {
        return num - 20;
    }
}
