package com.yonbip.app.kanban.control;

import com.yonbip.app.kanban.model.Result;
import com.yonbip.app.kanban.model.User;
import com.yonbip.app.kanban.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuzeyu
 * @description 用户
 * @github github.com/kkkkendei
 */
@Controller
public class UserTestControl {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/test/user")
    @ResponseBody
    public Map testUser() {
        Map result = new HashMap();

        Result<User> userResult = userService.register("LiSi", "123");

        if (userResult.getData() == null) {
            result.put("register", userResult.getMessage());
            return result;
        }

        User user = userResult.getData();
        result.put("register", user);

        List<Long> userIds = new ArrayList<>();
        userIds.add(user.getId());
        List<User> users = userService.findByIds(userIds);
        result.put("findByIds", users);

        return result;
    }

}
