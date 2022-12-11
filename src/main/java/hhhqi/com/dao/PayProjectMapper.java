package hhhqi.com.dao;

import hhhqi.com.entity.PayProject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 付费课程持久层
 * @create: 2022-11-20 14:58
 **/
@Mapper
public interface PayProjectMapper {

    /**
     * 查询所有项目
     *
     * @return
     */
    List<PayProject> selectAllPayProject();

    /**
     * 通过项目名称查
     *
     * @param keyword
     * @return
     */
    List<PayProject> selectPayProjectByPage(@Param("start") int start, @Param("end") int end, @Param("projectName") String projectName, @Param("projectPrice") String projectPrice);

    /**
     * 插入项目
     *
     * @param payProject
     */
    int insertPayProject(PayProject payProject);

    /**
     * 根据id删除项目
     * @param id
     */
    int deletePayProject(int id);

    /**
     *
     * @param payProject
     */
    int updatePayProject(PayProject payProject);

}
