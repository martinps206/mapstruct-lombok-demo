package com.martinps.test;

import com.martinps.DTO.GetProduct;
import com.martinps.entity.Product;
import com.martinps.mapper.ProductMapper;
import com.martinps.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class InitDatabase {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Bean
    public CommandLineRunner testProductMapperCommand(){
        return  args -> {

            List<Product> products = productRepository.findAll();
            System.out.println("PRODUCTS");
            products.forEach(System.out::println);

            System.out.println("GET PRODUCTS");
            List<GetProduct> getProductList = productMapper.toGetProductList(products);
            getProductList.forEach(System.out::println);
            //List<GetProduct> getProductList = products.stream().map(product -> productMapper.productToGetDTO(product)).peek(System.out::println).collect(Collectors.toList());


            System.out.println("MAPPED PRODUCTS");
            List<Product> mappedProducts = productMapper.toEntityList(getProductList);
            mappedProducts.forEach(System.out::println);
        };
    }


}
