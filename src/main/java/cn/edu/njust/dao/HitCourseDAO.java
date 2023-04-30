package cn.edu.njust.dao;

import cn.edu.njust.pojo.HitCourse;
import cn.edu.njust.pojo.Login;

import java.util.List;

/**
 * -*- coding: UTF-8 -*-
 *
 * @author GZ_WangSong
 * @date 2023/4/30
 */
public interface HitCourseDAO {
    List<HitCourse> getHitCourse(Login login);

    int withdrawalChoose(String[] ids);

    int chooseCourse(String[] cId, int id);
}
