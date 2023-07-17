package com.example.task.manager.api;

import com.example.task.manager.Output.ResponseList;
import com.example.task.manager.dto.UserDTO;
import com.example.task.manager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/manager/api/user")
public class UserAPI {
    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseList<UserDTO> findAllUser() {
        ResponseList result = new ResponseList<>();
        List<UserDTO> users = userService.findAll();
        result.setStatus("OK");
        result.setMessage("find all success");
        result.setData(users);
        return result;
    }
    @GetMapping(value = "/active")
    public ResponseList<UserDTO> findUserActive() {
        ResponseList result = new ResponseList<>();
        Pageable pageable = PageRequest.of(0,2);
        List<UserDTO> users = userService.findAllActive(pageable);
        result.setStatus("OK");
        result.setMessage("find all success");
        result.setData(users);
        return result;
    }

    @PostMapping
    public UserDTO insertUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PutMapping(value = "/{id}")
    public UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        if (id == null) {
           return userService.save(userDTO);
        }
       return userService.update(userDTO, id);
    }
    @DeleteMapping
    public void deleteUser(@RequestBody Long[] ids){
        userService.delete(ids);
    }

}
