package com.myblog.service.impl;

import com.myblog.entity.Post;
import com.myblog.exception.ResourceNotFoundException;
import com.myblog.payload.PostDto;
import com.myblog.repository.PostRepository;
import com.myblog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private ModelMapper modelMapper;

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post saved = postRepository.save(post);
        PostDto dto = mapToDto(saved);

        return dto;
    }

    @Override
    public PostDto getData(long id) {
        Post saved = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not found with" + id));
        PostDto dto = new PostDto();
        dto.setTitle(saved.getTitle());
        dto.setContent(saved.getContent());
        dto.setDescription(saved.getDescription());
        return dto;
    }

    @Override
    public List<PostDto> GetAllData(int pageNo, int pageSize, String sortBy, String sortDir) {
        // Create a Sort object based on the provided sortBy and sortDir parameters
        Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        // Create a Pageable object for pagination using the pageNo, pageSize, and the created Sort object
        Pageable pageable = PageRequest.of(pageNo, pageSize,sort);
        // Retrieve a page of Post entities from the postRepository using the created Pageable
        Page<Post> pagePost = postRepository.findAll(pageable);
        // Convert the List<Post> to a List<PostDto> using the mapToDto method
        List<Post> content = pagePost.getContent();
        List<PostDto> dtos = content.stream().map(postDto -> mapToDto(postDto)).collect(Collectors.toList());
        return dtos;
    }

    PostDto mapToDto(Post saved) {
        PostDto map = modelMapper.map(saved, PostDto.class);
        return map;
    }
    Post mapToEntity(PostDto postDto) {
        Post map = modelMapper.map(postDto, Post.class);
        return map;
    }
}
