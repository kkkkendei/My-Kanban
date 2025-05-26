package com.yonbip.app.kanban.service;

import com.yonbip.app.kanban.model.Result;
import com.yonbip.app.kanban.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {

    /**
     * 注册用户
     *
     * @param userName
     * @param pwd
     * @return
     */
    public Result<User> register(String userName, String pwd);

    /**
     * 执行登录逻辑，登录成功返回 User 对象
     *
     * @param userName
     * @param pwd
     * @return
     */
    public Result<User> login(String userName, String pwd);

    public User findByUserName(String userName);

    public List<User> findByIds(List<Long> ids);

    public List<User> search(String keyWord, LocalDateTime startTime, LocalDateTime endTime);

}
