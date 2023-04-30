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
public class CourseMapping {
    private static final RowProcessor processor;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("cId", "courseId");
        map.put("cName", "courseName");
        map.put("cPw", "courseNum");
        map.put("cType", "courseType");
        BeanProcessor beanProcessor = new BeanProcessor(map);
        processor = new BasicRowProcessor(beanProcessor);
    }

    public static RowProcessor getProcessor() {
        return processor;
    }
}
