package com.youkeda.app.kanban;

import com.youkeda.app.kanban.control.HelloControl;
import com.youkeda.app.kanban.dao.UserDAO;
import com.youkeda.app.kanban.dataobject.UserDO;
import org.assertj.core.api.Assertions;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KanbanApplication2Tests {
    private static final Logger LOG = LoggerFactory.getLogger(KanbanApplication2Tests.class);

    @Autowired
    private HelloControl helloControl;

    @Autowired
    private UserDAO userDAO;

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

            List<UserDO> users = userDAO.findAll();
            Assert.assertNotNull(users);

            LOG.info("check successful");
            LOG.info("检查完毕");
        } catch (Exception e) {
            LOG.error("检查出错，请对照错误信息提示修正程序。", e);
            throw e;
        }

    }

    private void checkClass() throws Exception {
        LOG.info("开始检查类是否存在：");
        try {
            Class sobjClass = Class.forName("com.youkeda.app.kanban.control.HelloControl");
        } catch (ClassNotFoundException cnfe) {
            LOG.error("缺少 com.youkeda.app.kanban.control.HelloControl");
            throw cnfe;
        }
        LOG.info("检查完毕");
    }
}
