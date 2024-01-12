package com.example.bookManagement.repository;

import com.example.bookManagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Book, Integer> {
}
