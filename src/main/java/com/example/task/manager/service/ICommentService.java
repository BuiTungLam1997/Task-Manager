package com.example.task.manager.service;

import com.example.task.manager.dto.CommentDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICommentService {
    List<CommentDTO> findAll();
    List<CommentDTO> findAll(Pageable pageable);
    CommentDTO save(CommentDTO commentDTO);
    CommentDTO update(CommentDTO commentDTO);
    void delete (Long[] ids);

}
