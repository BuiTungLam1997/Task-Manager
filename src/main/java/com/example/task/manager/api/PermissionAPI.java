package com.example.task.manager.api;

import com.example.task.manager.dto.PermissionDTO;
import com.example.task.manager.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/manager/api/permission")
public class PermissionAPI {
    @Autowired
    private IPermissionService permissionService;

    @GetMapping
    public List<PermissionDTO> findAll(){
        return permissionService.findAll();
    }
    @PostMapping
    public PermissionDTO insertPermission(@RequestBody PermissionDTO permissionDTO){
        return permissionService.save(permissionDTO);
    }
    @PutMapping(value = "/{id}")
    public PermissionDTO updatePermission(@RequestBody PermissionDTO permissionDTO ,@PathVariable Long id){
        if (id==null){
            return permissionService.save(permissionDTO);
        }
        permissionDTO.setId(id);
        return  permissionService.update(permissionDTO);
    }
    @DeleteMapping
    public void deletePermission (@RequestBody Long[] ids){
        permissionService.delete(ids);
    }
}
