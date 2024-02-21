package com.myblog.service.impl;

import com.myblog.entity.Comment;
import com.myblog.entity.Post;
import com.myblog.exception.ResourceNotFoundException;
import com.myblog.payload.CommentDto;
import com.myblog.repository.CommentRepository;
import com.myblog.repository.PostRepository;
import com.myblog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CommentServiceImpl implements CommentService {
    private ModelMapper modelMapper;
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentServiceImpl(ModelMapper modelMapper, PostRepository postRepository, CommentRepository commentRepository) {
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override


    //for the postid i have to get the post i require post repository
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post not found with id:" + postId));
        Comment comment = new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);
        Comment save = commentRepository.save(comment);
        CommentDto commentDto1 = new CommentDto();
        commentDto1.setId(save.getId());
        commentDto1.setEmail(save.getEmail());
        commentDto1.setText(save.getText());
        return commentDto1;
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto,@PathVariable long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found with postID" + postId));
        Comment comment = commentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Comment not found with id"+id));
    Comment c = mapToEntity(commentDto);
    c.setId(comment.getId());
    c.setPost(post);
        Comment save = commentRepository.save(c);
        CommentDto commentDto1 = mapToDto(save);

        return commentDto1;

    }
    Comment mapToEntity(CommentDto dto){
        Comment map = modelMapper.map(dto, Comment.class);
        return map;
    }
    CommentDto mapToDto(Comment comment){
        CommentDto map = modelMapper.map(comment, CommentDto.class);
        return map;
    }
}
