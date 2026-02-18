package com.efeerturk.gallery_project.repository;

import com.efeerturk.gallery_project.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query(value = "from Car")
    Page<Car> findAllPageable(Pageable pageable);
    List<Car>findByBrandIgnoreCase(String brand);

}
