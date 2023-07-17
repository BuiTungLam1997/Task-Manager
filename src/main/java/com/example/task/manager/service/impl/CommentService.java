package com.example.task.manager.service.impl;

import com.example.task.manager.dto.CommentDTO;
import com.example.task.manager.entity.CommentEntity;
import com.example.task.manager.repository.CommentRepository;
import com.example.task.manager.service.ICommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService implements ICommentService {
    ModelMapper mapper = new ModelMapper();
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<CommentDTO> findAll() {
        List<CommentDTO> result = new ArrayList<>();
        List<CommentEntity> comments = commentRepository.findAll();
        for (CommentEntity item : comments) {
            result.add(mapper.map(item, CommentDTO.class));
        }
        return result;
    }

    @Override
    public List<CommentDTO> findAll(Pageable pageable) {
        List<CommentDTO> result = new ArrayList<>();
        List<CommentEntity> comments = commentRepository.findAll(pageable).getContent();
        for (CommentEntity item : comments) {
            result.add(mapper.map(item, CommentDTO.class));
        }
        return result;
    }

    @Override
    public CommentDTO save(CommentDTO commentDTO) {
        commentRepository.save(mapper.map(commentDTO, CommentEntity.class));
        return mapper.map(commentRepository.findById(commentDTO.getId()), CommentDTO.class);
    }

    @Override
    public CommentDTO update(CommentDTO commentDTO) {
        commentRepository.save(mapper.map(commentDTO, CommentEntity.class));
        return mapper.map(commentRepository.findById(commentDTO.getId()), CommentDTO.class);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            commentRepository.deleteById(id);
        }
    }
}
