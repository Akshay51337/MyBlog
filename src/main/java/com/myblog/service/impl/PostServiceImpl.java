package com.myblog.service.impl;

import com.myblog.entity.Post;
import com.myblog.payload.PostDto;
import com.myblog.repository.PostRepository;
import com.myblog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
post.setTitle(postDto.getTitle());
post.setDescription(postDto.getDescription());
post.setContent(postDto.getContent());

        Post saved = postRepository.save(post);
        PostDto dto = new PostDto();
        dto.setTitle(saved.getTitle());
        dto.setContent(saved.getContent());
        dto.setDescription(saved.getDescription());
        return dto;
    }
}
