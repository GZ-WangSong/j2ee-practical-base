package cn.edu.njust.pojo;

public class Course {
    private String courseId;
    private String courseName;
    private int courseNum;
    private String courseType;

    public Course() {
    }

    public Course(String courseId, String courseName, int courseNum, String courseType) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseNum = courseNum;
        this.courseType = courseType;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }
}
