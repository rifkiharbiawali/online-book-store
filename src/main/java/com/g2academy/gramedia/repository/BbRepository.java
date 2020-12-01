package com.g2academy.gramedia.repository;

import com.g2academy.gramedia.domain.Bb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BbRepository extends JpaRepository<Bb, Long> {
}
