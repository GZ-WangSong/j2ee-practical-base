package cn.edu.njust.service;

import cn.edu.njust.pojo.Course;

public interface CourseService {
    int addCourse(Course course);

    int deleteCourse(String []s);

    int withdrawalChoose(String[] sId);

    int chooseCourse(String[] cId, int id);
}
