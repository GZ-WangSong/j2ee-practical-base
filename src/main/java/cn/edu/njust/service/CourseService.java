package cn.edu.njust.service;

import cn.edu.njust.pojo.Course;

import java.util.List;

public interface CourseService {
    int addCourse(Course course);

    int deleteCourse(String []s);

    int withdrawalChoose(String[] sId);

    int chooseCourse(String[] cId, int id);

    int getTotalCount();

    List<Course> queryCourseByPage(int currentPage, int pageSize);
}
