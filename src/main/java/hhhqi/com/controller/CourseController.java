package hhhqi.com.controller;

import hhhqi.com.entity.Course;
import hhhqi.com.entity.Result;
import hhhqi.com.server.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: gym-management-system
 * @author: hhhqi
 * @description: 课程信息控制层
 * @create: 2022-11-27 14:17
 **/

@RestController
@RequestMapping("/course")
public class CourseController {

    private CourseServiceImpl courseServiceImpl;

    @Autowired
    public CourseController(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    @GetMapping("/chaXunFenYe")
    public Result getCourseByPage(@RequestParam("page") Integer startPage,
                                                    @RequestParam("limit")Integer pageSize,
                                                    @RequestParam("courseName")String courseName,
                                                    @RequestParam("courseCoach")String courseCoach){

        return courseServiceImpl.getCourseByPage(startPage,pageSize, courseName, courseCoach);
    }

    @GetMapping("/chaXunAll")
    public Result getCourseAll(){
        return courseServiceImpl.getCourseAll();
    }

    @PostMapping("/xingZeng")
    public Result addCourse(Course course){
        return courseServiceImpl.insertCourse(course);
    }

    @PutMapping("/update")
    public Result modifyCourse(Course course){
        return courseServiceImpl.updateCourse(course);
    }

    @DeleteMapping("/delete")
    public Result deleteCourse(@RequestParam("courseId") String id){
        return courseServiceImpl.deleteCourse(id);
    }
}
