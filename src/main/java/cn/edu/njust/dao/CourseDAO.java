package cn.edu.njust.dao;

import cn.edu.njust.pojo.Course;

import java.util.List;

/**
 * -*- coding: UTF-8 -*-
 *
 * @IDE: IntelliJ IDEA
 * @Author: GZ-WangSong
 * @Date: 2023/4/29 15:51
 * @Description:
 */
public interface CourseDAO {
    List<Course> getCourse();
    int deleteCourse(String[] s);
}
