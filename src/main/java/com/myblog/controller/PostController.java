package com.myblog.controller;

import com.myblog.entity.Post;
import com.myblog.payload.PostDto;
import com.myblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PreAuthorize("hasRole('ADMIN')")
@PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto post = postService.createPost(postDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
    @GetMapping("/particular")
    public ResponseEntity<?>getData(@RequestParam long id){

        PostDto data = postService.getData(id);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
    @GetMapping
    public List<PostDto> GetAllData(@RequestParam (name="pageNo", required = false, defaultValue = "0") int pageNo,
                                    @RequestParam (name="pageSize", required = false, defaultValue = "0") int pageSize,
                                    @RequestParam (name="sortBy", required = false, defaultValue = "id") String sortBy,
                                    @RequestParam (name="sortDir", required = false, defaultValue = "id") String sortDir){

        List<PostDto> dtos = postService.GetAllData(pageNo, pageSize, sortBy, sortDir);
        return dtos;
    }
}
