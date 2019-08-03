package com.h2t.study.controller;

import com.h2t.study.pojo.Users;
import com.h2t.study.service.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hetiantian
 * @since 2019-08-02
 */
@RestController
@RequestMapping("/api/user")
public class UsersController {
    @Resource
    private UsersService usersService;

    @PostMapping
    public Object save(@RequestBody Users users) {
        return usersService.save(users);
    }

    @PostMapping("/userslist")
    public Object saveBatch(@RequestBody List<Users> objList) {
        return usersService.saveBatch(objList);
    }

    @DeleteMapping("/{id}")
    public Object removeById(@PathVariable Long id) {
        return usersService.removeById(id);
    }

    @DeleteMapping
    public Object remove(@RequestBody Users users) {
        return usersService.remove(users);
    }

    @DeleteMapping("/list")
    public Object removeBatch(@RequestBody List<Long> idList) {
        return usersService.removeBatch(idList);
    }


    @PutMapping()
    public Object modifyById(@RequestBody Users users) {
        return usersService.modifyById(users);
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id) {
        return usersService.getById(id);
    }

    @PostMapping("/list")
    public Object list(@RequestBody Users users) {
        return usersService.list(users);
    }

    @PostMapping("/idList")
    public Object listById(@RequestBody List<Long> idList) {
        return usersService.listById(idList);
    }


}

