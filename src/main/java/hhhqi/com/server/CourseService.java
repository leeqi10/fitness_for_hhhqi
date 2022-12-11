package hhhqi.com.server;

import hhhqi.com.entity.Course;
import hhhqi.com.entity.Result;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 课程信息业务层接口
 * @create: 2022-11-26 08:58
 **/
public interface CourseService {

    Result getCourseAll();
    /**
     * 分页查询课程信息
     *
     * @param startPage 起始页码
     * @param pageSize  页面容量
     * @return 课程信息
     */
    Result getCourseByPage(Integer startPage, Integer pageSize, String courseName, String courseCoach);


    /**
     * 插入课程信息
     *
     * @param course
     * @return
     */
    Result insertCourse(Course course);

    /**
     * 更新课程信息
     *
     * @param course 课程信息
     * @return
     */
    Result updateCourse(Course course);


    /**
     * 根据id删除课程
     *
     * @param id 课程id
     * @return
     */
    Result deleteCourse(String id);

}
