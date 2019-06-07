package com.haeseong.sirenorder.model.service;

import com.haeseong.sirenorder.model.entity.Beverage;
import com.haeseong.sirenorder.model.repository.BeverageRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class BeverageServiceImpl implements BeverageService {
    private final BeverageRepository beverageRepository;

    @Override
    public List<Beverage> getBeverages() {
        final Collection<Beverage> beverages = beverageRepository.findAll();
        return new ArrayList<>(beverages);
    }
}
