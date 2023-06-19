package com.example.restapi.services.impls;

import com.example.restapi.models.entities.Blog;
import com.example.restapi.repositories.BlogRepository;
import com.example.restapi.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    @Async
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Void save(Blog blog) {
        blogRepository.save(blog);
        return null;
    }

    @Override
    @Async
    public Blog findById(Long id) {
        return blogRepository.findById(id).get();
    }
}
