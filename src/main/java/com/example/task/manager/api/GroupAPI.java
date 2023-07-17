package com.example.task.manager.api;

import com.example.task.manager.dto.GroupDTO;
import com.example.task.manager.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "manager/api/group")
public class GroupAPI {
    @Autowired
    private IGroupService groupPermissionService;

    @GetMapping
    public List<GroupDTO> findAll() {
        return groupPermissionService.findAll();
    }

    @PostMapping
    public GroupDTO insertGroup(@RequestBody GroupDTO groupDTO){
        return groupPermissionService.save(groupDTO);
    }
    @PutMapping("/{id}")
    public GroupDTO updateGroup (@RequestBody GroupDTO groupDTO, @PathVariable Long id){
        if(id==null){
            return groupPermissionService.save(groupDTO);
        }
        groupDTO.setId(id);
        return groupPermissionService.update(groupDTO);
    }
    @DeleteMapping
    public void deleteGroup(@PathVariable Long[] ids){
        groupPermissionService.delete(ids);
    }
}
