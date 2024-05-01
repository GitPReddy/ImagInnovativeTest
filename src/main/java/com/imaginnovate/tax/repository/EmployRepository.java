package com.imaginnovate.tax.repository;

import com.imaginnovate.tax.entity.Employ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployRepository extends JpaRepository<Employ, Integer> {

}
