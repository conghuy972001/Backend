package com.nguyenconghuy.backend.repository;

import com.nguyenconghuy.backend.entity.RegisInternship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RegisInternshipRepository extends JpaRepository<RegisInternship, UUID> {
}
