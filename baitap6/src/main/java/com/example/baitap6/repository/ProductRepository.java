package com.example.baitap6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.baitap6.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
