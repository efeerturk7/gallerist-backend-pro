package com.efeerturk.gallery_project.repository;

import com.efeerturk.gallery_project.model.Gallerist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleristRepository extends JpaRepository<Gallerist, Long> {

}
