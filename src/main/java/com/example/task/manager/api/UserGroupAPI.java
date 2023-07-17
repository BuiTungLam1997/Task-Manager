package com.example.task.manager.api;

import com.example.task.manager.dto.UserGroupDTO;
import com.example.task.manager.service.IUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/manager/api/user_group")
public class UserGroupAPI {
    @Autowired
    private IUserGroupService userGroupService;
    @GetMapping
    public List<UserGroupDTO> findAll(){
        return userGroupService.findAll();
    }
    @PostMapping
    public UserGroupDTO insertUserGroup (@RequestBody UserGroupDTO userGroupDTO){
        return userGroupService.save(userGroupDTO);
    }
    @PutMapping(value = "/{id}")
    public UserGroupDTO updateUserGroup(@RequestBody UserGroupDTO userGroupDTO,@PathVariable Long id){
        if(id==null){
            return userGroupService.save(userGroupDTO);
        }
        userGroupDTO.setId(id);
        return userGroupService.update(userGroupDTO);
    }
    @DeleteMapping
    public void deleteUserGroup(@PathVariable Long[] ids){
        userGroupService.delete(ids);
    }
}
