package com.example.demo.Service;

import com.example.demo.dao.user_info;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserService {

    //查询用户

    @WebMethod
    user_info getUser(String usercode);

    //查询所有用户

    @WebMethod
    List<user_info> getAllUser();
}
