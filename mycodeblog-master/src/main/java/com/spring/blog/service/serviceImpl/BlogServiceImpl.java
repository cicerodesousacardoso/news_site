package com.spring.blog.service.serviceImpl;

import com.spring.blog.model.Post;
import com.spring.blog.repository.BlogRepository;
import com.spring.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Post> findAll() {
        return blogRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Post findById(long id) {
        Optional<Post> postOptional = blogRepository.findById(id);
        if (postOptional.isPresent()) {
            return postOptional.get();
        } else {
            // Handle the case when the post is not found
            throw new RuntimeException("Post not found for id :: " + id);
        }
    }

    @Override
    public Post save(Post post) {
        return blogRepository.save(post);
    }
}
