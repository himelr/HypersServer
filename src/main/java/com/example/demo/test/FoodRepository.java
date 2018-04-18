package com.example.demo.test;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface FoodRepository extends CrudRepository<Food, Long> {

}
