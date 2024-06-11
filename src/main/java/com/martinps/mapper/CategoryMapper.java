package com.martinps.mapper;

import com.martinps.DTO.GetCategory;
import com.martinps.entity.Category;
import com.martinps.repository.CategoryRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CategoryMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    @Mappings({
            @Mapping(source = "id", target = "categoryId"),
            @Mapping(source = "name", target = "categoryName")
    })

    abstract GetCategory toGetCategory(Category category);

    Category toEntity(GetCategory getCategory){
        if (getCategory == null) return null;

        Category category = categoryRepository.findById(getCategory.getCategoryId()).orElse(null);

        if (category == null) return null;

        category.setId(getCategory.getCategoryId());
        category.setName(getCategory.getCategoryName());

        return category;
    }

    abstract List<GetCategory> toGetCategoryList(List<Category> categoryList);

    abstract List<Category> toEntityList(List<GetCategory> getCategoryList);

}
