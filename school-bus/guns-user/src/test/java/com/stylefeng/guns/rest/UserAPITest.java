/**
 * @program school-bus
 * @description: UserTest
 * @author: mf
 * @create: 2020/02/25 15:36
 */

package com.stylefeng.guns.rest;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.user.UserAPI;
import com.stylefeng.guns.rest.user.vo.UserCheckRequest;
import com.stylefeng.guns.rest.user.vo.UserCheckResponse;
import com.stylefeng.guns.rest.user.vo.UserRegisterRequest;
import com.stylefeng.guns.rest.user.vo.UserRegisterResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GunsUserApplication.class})
public class UserAPITest {

    @Reference
    private UserAPI userAPI;

    @Test
    public void checkUsernameTest() {
        UserCheckRequest req = new UserCheckRequest();
        req.setUsername("admin");
        UserCheckResponse res = userAPI.checkUsername(req);
        System.out.println(res);
    }

    @Test
    public void registerTest() {
        UserRegisterRequest request = new UserRegisterRequest();
        request.setUsername("mai");
        request.setPassword("123");
        request.setEmail("123@qq.com");
        request.setPhone("123");
        UserRegisterResponse response = userAPI.regsiter(request);
        System.out.println(response);
    }

}
