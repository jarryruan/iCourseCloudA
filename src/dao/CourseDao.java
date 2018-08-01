package dao;

import dao.impl.CourseDaoImpl;
import domain.Course;
import domain.User;

import java.util.List;

public interface CourseDao {
    static CourseDao getInstance(){ return CourseDaoImpl.getInstance(); }

    int create(Course course);

    Course getById(int id);

    List<Course> getByCreator(User creator);

    List<Course> getAll();

    void delete(int id);

    void update(int id, Course course);

    List<Course> getCourseOrderByEngagement(int limit);

    List<Course> getCourseOrderByTime(int limit);

    List<Course> getCoursesByNameLike(String keyword, int skip, int limit);

    List<Course> getCoursesByCreatorNameLike(String keyword, int skip, int limit);
}
