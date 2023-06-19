package com.example.restapi.services;

import com.example.restapi.models.entities.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Void save(Blog blog);
    Blog findById(Long id);
}
