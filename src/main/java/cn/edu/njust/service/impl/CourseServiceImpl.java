package cn.edu.njust.service.impl;

import cn.edu.njust.dao.CourseDAO;
import cn.edu.njust.dao.impl.CourseDAOImpl;
import cn.edu.njust.pojo.Course;
import cn.edu.njust.service.CourseService;

public class CourseServiceImpl implements CourseService {
    private final CourseDAO courseDAO = new CourseDAOImpl();

    public int addCourse(Course course) {
        return courseDAO.addCourse(course);
    }

    public int deleteCourse(String[] s) {
        return courseDAO.deleteCourse(s);
    }
}
