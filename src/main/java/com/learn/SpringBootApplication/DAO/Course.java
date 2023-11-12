package com.learn.SpringBootApplication.DAO;

public class Course {

    private int courseId;
    private String courseName;
    private long coursePrice;

    public int getCourseId() {
        return courseId;
    }

    public Course(int courseId, String courseName, long coursePrice) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public long getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(long coursePrice) {
        this.coursePrice = coursePrice;
    }
}
