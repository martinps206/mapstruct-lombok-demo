package com.martinps.mapper;

import com.martinps.DTO.GetProduct;
import com.martinps.entity.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "name", target = "productName"),
            @Mapping(source = "creationDate", target = "creationDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source = "category", target = "productCategory"),
            @Mapping(source = "price", target = "price", numberFormat = "$#.00")
    })
    GetProduct productToGetDTO(Product product);

    @InheritInverseConfiguration
    Product toEntity(GetProduct getProduct);

    List<GetProduct> toGetProductList(List<Product> productList);

    List<Product> toEntityList(List<GetProduct> getProductList);

}
