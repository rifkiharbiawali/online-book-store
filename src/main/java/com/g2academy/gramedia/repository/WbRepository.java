package com.g2academy.gramedia.repository;

import com.g2academy.gramedia.domain.Wb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WbRepository extends JpaRepository<Wb, Long> {
}
