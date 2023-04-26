package com.nguyenconghuy.backend.repository;

import com.nguyenconghuy.backend.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {

}
