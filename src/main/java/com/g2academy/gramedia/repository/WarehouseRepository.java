package com.g2academy.gramedia.repository;

import com.g2academy.gramedia.domain.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    @Query("SELECT w FROM Warehouse w JOIN w.wbs wb WHERE wb.book.isbn LIKE %?1%")
    List<Warehouse> findIsbn(String keyword);

    @Query("SELECT w FROM Warehouse w JOIN w.wbs wb WHERE wb.book.title LIKE %?1%")
    List<Warehouse> findTitle(String keyword);

    @Query("SELECT w FROM Warehouse w JOIN w.wbs wb WHERE wb.book.author.name LIKE %?1%")
    List<Warehouse> findAuthor(String keyword);
//
    @Query("SELECT w FROM Warehouse w JOIN w.wbs wb WHERE wb.book.publisher.name LIKE %?1%")
    List<Warehouse> findPublisher(String keyword);
}
