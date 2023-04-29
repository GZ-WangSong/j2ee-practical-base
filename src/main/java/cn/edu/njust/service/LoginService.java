package cn.edu.njust.service;

/**
 * -*- coding: UTF-8 -*-
 *
 * @IDE: IntelliJ IDEA
 * @Author: GZ-WangSong
 * @Date: 2023/4/29 11:26
 * @Description:
 */
public interface LoginService {
    Integer randomInt(int value);
    String getResult(String name, String psw, String code);

    boolean checkEmpty(String name, String password, String safeCode);

    boolean checkSafeCode(String safeCode);
}
