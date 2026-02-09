package com.efeerturk.gallery_project.repository;

import com.efeerturk.gallery_project.model.SaledCar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SaledCarRepository extends JpaRepository<SaledCar, Long> {
    @Query(value = "from SaledCar")
    public Page<SaledCar> findAllPageable(Pageable pageable);


}
