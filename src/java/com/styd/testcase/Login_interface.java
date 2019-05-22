package com.styd.testcase;

import com.styd.Sql_Mapping.Login;
import com.styd.config.SqlDataBaseUtil;
import com.styd.until.Http_Client;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Login_interface {
    @Test
    public void test() throws Exception {
        Login logincase = (Login) SqlDataBaseUtil.getTestData("test_login",1);

        JSONObject params = new JSONObject();
        params.put("name",logincase.getName());
        params.put("password",logincase.getPassword());
        String result = Http_Client.doPost("https://api-saas-dev.styd.cn/login/account",params);
        JSONObject response = new JSONObject(result);
        //获取token，后续接口的header中需要添加
        System.out.println(response.get("msg"));
        Assert.assertEquals(response.get("msg"),logincase.getExcepted());
//        Http_Client.token = response.getJSONObject("data").get("token").toString();
















        }
}
