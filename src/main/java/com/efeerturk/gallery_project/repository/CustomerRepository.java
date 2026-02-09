package com.efeerturk.gallery_project.repository;

import com.efeerturk.gallery_project.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "from Customer")
    public Page<Customer> findAllPageable(Pageable pageable);

}
