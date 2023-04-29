package cn.edu.njust.dao;

import cn.edu.njust.pojo.Course;

/**
 * -*- coding: UTF-8 -*-
 *
 * @IDE: IntelliJ IDEA
 * @Author: GZ-WangSong
 * @Date: 2023/4/29 15:51
 * @Description:
 */
public interface CourseDAO {
    Course readCourse();
    int deleteCourse(String[] s);
}
