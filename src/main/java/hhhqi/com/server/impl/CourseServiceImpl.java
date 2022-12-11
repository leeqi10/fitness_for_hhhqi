package hhhqi.com.server.impl;

import hhhqi.com.dao.CourseMapper;
import hhhqi.com.entity.Course;
import hhhqi.com.entity.Result;
import hhhqi.com.server.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 课程业务类实现
 * @create: 2022-11-27 11:08
 **/
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;


    public CourseServiceImpl(@Autowired CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public Result getCourseByPage(Integer startPage, Integer pageSize, String courseName, String courseCoach) {
        List<Course> allCourse=courseMapper.getCourseByPage((startPage-1)*pageSize, pageSize, courseName, courseCoach);
        return new Result<>(Result.OK,"查询成功", courseMapper.getCourseByPage(0, 1000000, courseName,courseCoach).size(),allCourse);
    }

    public Result getCourseAll() {
        List<Course> allCourse=courseMapper.getAllCourse();
        return new Result<>(Result.OK,"查询成功", allCourse.size(),allCourse);
    }



    public Result insertCourse(Course course) {
        Object obj = courseMapper.insertCourse(course);
        return new Result(Result.OK, "添加成功",1, obj);
    }

    public Result updateCourse(Course course) {
        Object obj = courseMapper.updateCourse(course);
        return new Result(Result.OK,"修改成功",1,obj);
    }

    public Result deleteCourse(String id) {
        Object obj = courseMapper.deleteCourse(id);
        return new Result(Result.OK,"删除成功",1 ,obj);
    }
}
