package com.myblog.service;

import com.myblog.payload.PostDto;

import java.util.List;

public interface PostService {

PostDto createPost(PostDto postDto);


    PostDto getData(long id);

    List<PostDto> GetAllData(int pageNo, int pageSize, String sortBy, String sortDir);
}
