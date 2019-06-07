package com.haeseong.sirenorder.model.service;

import com.haeseong.sirenorder.model.entity.Category;
import com.haeseong.sirenorder.model.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        final Collection<Category> categories = categoryRepository.findAll();
        return new ArrayList<>(categories);
    }
}
