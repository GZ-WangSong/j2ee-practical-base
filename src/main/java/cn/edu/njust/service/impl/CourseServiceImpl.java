package cn.edu.njust.service.impl;

import cn.edu.njust.dao.CourseDAO;
import cn.edu.njust.dao.HitCourseDAO;
import cn.edu.njust.dao.impl.CourseDAOImpl;
import cn.edu.njust.dao.impl.HitCourseDAOImpl;
import cn.edu.njust.pojo.Course;
import cn.edu.njust.service.CourseService;

public class CourseServiceImpl implements CourseService {
    private final CourseDAO courseDAO = new CourseDAOImpl();
    private final HitCourseDAO hitCourseDAO = new HitCourseDAOImpl();

    @Override
    public int addCourse(Course course) {
        return courseDAO.addCourse(course);
    }

    @Override
    public int deleteCourse(String[] s) {
        return courseDAO.deleteCourse(s);
    }

    /**
     * 退选课程
     * @param sId 选中的ID
     * @return 返回影响的行数
     */
    @Override
    public int withdrawalChoose(String[] sId) {
        return hitCourseDAO.withdrawalChoose(sId);
    }

    @Override
    public int chooseCourse(String[] cId, int id) {
        return hitCourseDAO.chooseCourse(cId, id);
    }
}
