package com.example.task.manager.api;

import com.example.task.manager.dto.CommentDTO;
import com.example.task.manager.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "manager/api/comment")
public class CommentAPI {
    @Autowired
    private ICommentService commentService;
    @GetMapping
    public List<CommentDTO> findAll(){
        return commentService.findAll();
    }
    @PostMapping
    public CommentDTO insertComment(@RequestBody CommentDTO commentDTO){
        return commentService.save(commentDTO);
    }
    @PutMapping(value = "/{id}")
    public CommentDTO updateComment(@RequestBody CommentDTO commentDTO,@PathVariable Long id){
        if(id==null){
            return commentService.save(commentDTO);
        }
        commentDTO.setId(id);
        return commentService.update(commentDTO);
    }
    @DeleteMapping
    public void deleteComment(@RequestBody Long[] ids){
       commentService.delete(ids);
    }
}
