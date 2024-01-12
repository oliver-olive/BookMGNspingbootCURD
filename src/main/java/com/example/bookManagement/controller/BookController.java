package com.example.bookManagement.controller;


import com.example.bookManagement.entity.Book;
import com.example.bookManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    ProductRepository productRepository;


    @RequestMapping(value = "/Books", method = RequestMethod.POST)
    public Book createBook(@RequestBody Book bk){
        return productRepository.save(bk);
    }
    @RequestMapping(value = "/Book/{id}", method = RequestMethod.GET)
    public Book getProduct(@PathVariable("id") int id){
        return productRepository.findById(id).get();
    }
    @RequestMapping(value = "/Books", method =  RequestMethod.PUT)
    public void update(@RequestBody Book bk){
        Book book = productRepository.findById(bk.getBook_id()).get();
        book.setBook_name(bk.getBook_name());
        book.setPrice(bk.getPrice());
        productRepository.save(book);
    }
    @RequestMapping(value = "/Book/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") int id){
         productRepository.deleteById(id);
    }
}
