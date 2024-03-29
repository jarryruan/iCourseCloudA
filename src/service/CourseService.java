package service;

import domain.Course;
import exception.ServiceException;
import service.impl.CourseServiceImpl;

import java.util.List;

/**
 * 课程操作类
 */
public interface CourseService {

    static CourseService getInstance() { return CourseServiceImpl.getInstance(); }

    /**
     * 获取当前所有的课程列表
     * @return 所有课程的列表
     */
    List<Course> getAllCourse();

    /**
     * 创建课程
     * @param creatorUsername 开课者用户名
     * @param name 课程名
     * @param description 课程简介
     * @return 创建的课程ID
     * @throws ServiceException 操作失败时抛出的异常，通过e.getMessage()获得错误原因
     */
    int createCourse(String creatorUsername, String name, String description) throws ServiceException;

    /**
     * 选课
     * @param username 用户名
     * @param courseId 课程ID
     * @throws ServiceException 操作失败时抛出的异常，通过e.getMessage()获得错误原因
     */
    void selectCourse(String username, int courseId) throws ServiceException;

    /**
     * 退课
     * @param username 用户名
     * @param courseId 课程ID
     * @throws ServiceException 操作失败时抛出的异常，通过e.getMessage()获得错误原因
     */
    void dropCourse(String username, int courseId) throws ServiceException;

    /**
     * 获取课程资源文件夹URL（既在浏览器中的访问地址）
     * @param courseId 课程ID
     * @return 文件夹URL
     */
    String getResourceFolderURL(int courseId);

    /**
     * 获取课程资源文件夹在本地的路径
     * @param courseId 课程ID
     * @return 文件夹路径
     */
    String getResourceFolderLocalPath(int courseId);

    /**
     * 获取课程中所有资源的文件名
     * （可与getResourceFolderURL 或者 getResourceFolderLocalPath方法结合得到完整地址）
     * @param courseId 课程ID
     * @return 文件名列表
     */
    List<String> getListOfResourceFilename(int courseId);


    /**
     * 获取课程封面图像URL（既在浏览器中的访问地址）
     * @param courseId 课程ID
     * @return URL
     */
    String getCoverURL(int courseId);

    /**
     * 获取课程封面图像在本地的路径
     * @param courseId 课程ID
     * @return 封面图像路径
     */
    String getCoverLocalPath(int courseId);

    /**
     * 得到一个用户选的所有课
     * @param username 用户名
     * @return 课程对象列表
     * @throws ServiceException 操作失败时抛出的异常，通过e.getMessage()获得错误原因
     */
    List<Course> getSelectedCourses(String username) throws ServiceException;

    /**
     * 得到一个用户创建的所有课
     * @param creatorUsername 用户名
     * @return 课程对象列表
     * @throws ServiceException 操作失败时抛出的异常，通过e.getMessage()获得错误原因
     */
    List<Course> getCreatedCourses(String creatorUsername) throws ServiceException;

    /**
     * 通过课程ID获取课程对象
     * @param id 课程ID
     * @return 课程对象列表
     */
    Course getCourseById(int id);

    /**
     * 删除课程
     * @param id 课程ID
     */
    void deleteCourseById(int id);


    /**
     * 更改课程信息
     * @param id 要修改的课程ID
     * @param name 课程名
     * @param description 课程描述
     * @throws ServiceException 操作失败时抛出的异常，通过e.getMessage()获得错误原因
     */
    void updateCourse(int id, String name, String description) throws ServiceException;


    /**
     * 按名称搜索课程（按照选课人数倒序排序）
     * @param keyword 关键词
     * @param skip 跳过多少课程（用于翻页）
     * @param limit 一共取出多少条记录（用于翻页）
     * @return 搜索到的课程对象列表
     */
    List<Course> searchCourseByNameOrderByEngagement(String keyword, int skip, int limit);

    /**
     * 按开课老师搜索课程（按照选课人数倒序排序）
     * @param keyword 关键词
     * @param skip 跳过多少课程（用于翻页）
     * @param limit 一共取出多少条记录（用于翻页）
     * @return 搜索到的课程对象列表
     */
    List<Course> searchCourseByCreatorNameOrderByEngagement(String keyword, int skip, int limit);

    /**
     * 按名称搜索课程（按照创建时间倒序排序）
     * @param keyword 关键词
     * @param skip 跳过多少课程（用于翻页）
     * @param limit 一共取出多少条记录（用于翻页）
     * @return 搜索到的课程对象列表
     */
    List<Course> searchCourseByNameOrderByCreateTime(String keyword, int skip, int limit);

    /**
     * 按开课老师搜索课程（按照创建时间倒序排序）
     * @param keyword 关键词
     * @param skip 跳过多少课程（用于翻页）
     * @param limit 一共取出多少条记录（用于翻页）
     * @return 搜索到的课程对象列表
     */
    List<Course> searchCourseByCreatorNameOrderByCreateTime(String keyword, int skip, int limit);

    /**
     * 获取关键词（课程名称）能搜索到的课程总数
     * @param keyword 关键词
     * @return 课程总数
     */
    int getSearchCountByName(String keyword);

    /**
     * 获取关键词（开课老师）能搜索到的课程总数
     * @param keyword 关键词
     * @return 课程总数
     */
    int getSearchCountByCreatorName(String keyword);

    /**
     * 取出选课人数排名前若干名的课程
     * @param limit 取出的课程数
     * @return 课程列表
     */
    List<Course> getCourseOrderByEngagement(int limit);

    /**
     * 取出创建时间排名前若干名的课程
     * @param limit 取出的课程数
     * @return 课程列表
     */
    List<Course> getCourseOrderByCreateTime(int limit);

    /**
     * 检查用户是否有修改课程的权限
     * @param username 用户名
     * @param courseId 课程ID
     * @throws ServiceException 若没有权限，可以通过e.getMessage()获得原因
     */
    void checkUpdatePrivilege(String username , int courseId) throws ServiceException;
}
