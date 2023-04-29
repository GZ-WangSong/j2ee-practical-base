package cn.edu.njust.service.impl;

import cn.edu.njust.service.LoginService;

import java.util.Random;

/**
 * -*- coding: UTF-8 -*-
 *
 * @IDE: IntelliJ IDEA
 * @Author: GZ-WangSong
 * @Date: 2023/4/28 19:38
 * @Description:
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public Integer randomInt(int value) {
        // 获取随机数
        Random random = new Random();
        int ranNum = random.nextInt(10);

        if (value % 2 == 0) {
            return ranNum;
        }else {
            return ranNum + 10;
        }
    }

    @Override
    public String getResult(String name, String psw, String code) {
        // 获取输入字符中的序号
        int index = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) >= '0' && name.charAt(i) <= '9') {
                index = i;
                break;
            }
        }

        // 分离姓名和序号
        String username = name.substring(0, index);
        int num = Integer.parseInt(name.substring(index));
        Integer value = randomInt(num + Integer.parseInt(code));

        return username + " " + code + " " + num + " " + value;
    }

    @Override
    public boolean checkEmpty(String name, String password, String safeCode) {
        return name.isEmpty() || password.isEmpty() || safeCode.isEmpty();
    }

    @Override
    public boolean checkSafeCode(String safeCode) {
        return safeCode.equals("8774");
    }
}
