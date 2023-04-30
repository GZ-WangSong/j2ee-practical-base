package cn.edu.njust.mapping;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.RowProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * -*- coding: UTF-8 -*-
 *
 * @author GZ_WangSong
 * @date 2023/4/30
 */
public class LoginMapping {
    private static final RowProcessor processor;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("uId", "id");
        map.put("uName", "name");
        map.put("uPw", "password");
        map.put("uSchool", "school");
        map.put("uDepartment", "department");
        BeanProcessor beanProcessor = new BeanProcessor(map);
        processor = new BasicRowProcessor(beanProcessor);
    }

    public static RowProcessor getProcessor() {
        return processor;
    }
}
