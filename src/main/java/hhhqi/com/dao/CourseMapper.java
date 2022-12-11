package hhhqi.com.dao;

import hhhqi.com.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 课程信息持久层
 * @create: 2022-11-18 15:40
 **/
@Mapper
public interface CourseMapper {

    /**
     * 查询所有课程信息
     *
     * @return 课程信息
     */
    List<Course> getAllCourse();


    /**
     * 根据课程名字模糊查询课程信息
     *
     * @param
     * @return 课程信息
     */
    List<Course> getCourseByPage(@Param("start") int start, @Param("end") int end, @Param("courseName") String courseName,@Param("courseCoach") String courseCoach);

    /**
     * 新增课程信息
     *
     * @param course
     */
    int insertCourse(Course course);

    /**
     * 更新课程信息
     *
     * @param course
     */
    int updateCourse(Course course);

    /**
     * 根据id删除课程信息
     *
     * @param courseId
     */
    int deleteCourse(String courseId);

}
