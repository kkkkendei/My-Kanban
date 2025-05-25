package com.yonbip.app.kanban;

import com.yonbip.app.kanban.dao.UserDAO;
import com.yonbip.app.kanban.dataobject.UserDO;
import com.yonbip.app.kanban.model.Result;
import com.yonbip.app.kanban.model.User;
import com.yonbip.app.kanban.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @author wuzeyu
 * @description
 * @github github.com/kkkkendei
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KanbanApplication3Tests {
    private static final Logger LOG = LoggerFactory.getLogger(KanbanApplication3Tests.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    /**
     * 所有测试方法执行之前执行该方法
     */
    @BeforeEach
    public void before() {
        //获取mockmvc对象实例
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void contextLoads() throws Exception {
        try {
            checkClass();

            LOG.info("开始检查 /index 调用：");

            Result<User> regResult = userService.register("测试用户1", "123abc");

            Assert.assertNotNull("调用 userService.register() 失败，返回值为 null", regResult);
            Assert.assertNotNull("调用 userService.register() 失败，没有返回 User 实例", regResult.getData());

            User user = regResult.getData();

            Assert.assertTrue("调用 userService.register() 失败，返回 User 实例的 id 为 0", user.getId() > 0);

            List<UserDO> users = userDAO.findAll();
            Assert.assertNotNull("userDAO.findAll() 不能返回 null", users);

            userDAO.delete(user.getId());

            LOG.info("check successful");
            LOG.info("检查完毕");
        } catch (Exception e) {
            LOG.error("检查出错，请对照错误信息提示修正程序。", e);
            throw e;
        }

    }

    private void checkClass() throws Exception {
        LOG.info("开始检查类是否存在：");

        LOG.info("检查完毕");
    }
}