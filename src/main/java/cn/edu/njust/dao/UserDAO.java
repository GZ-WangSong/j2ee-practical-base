package cn.edu.njust.dao;

import cn.edu.njust.pojo.Login;

/**
 * -*- coding: UTF-8 -*-
 *
 * @IDE: IntelliJ IDEA
 * @Author: GZ-WangSong
 * @Date: 2023/4/29 11:29
 * @Description:
 */
public interface UserDAO {
    int queryByName(Login login);
}
