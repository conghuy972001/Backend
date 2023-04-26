package com.nguyenconghuy.backend.repository;

import com.nguyenconghuy.backend.entity.RegisSA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegisSARepository extends JpaRepository<RegisSA, UUID> {
}
