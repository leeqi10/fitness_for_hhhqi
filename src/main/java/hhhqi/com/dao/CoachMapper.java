package hhhqi.com.dao;

import hhhqi.com.entity.Coach;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 教练接口层
 * @create: 2022-11-17 11:30
 **/
@Mapper
public interface CoachMapper {

    /**
     * 查询所有教练
     *
     * @return
     */
    List<Coach> getAllCoach();

    /**
     * 根据关键字模拟查询教练信息
     *
     * @param keyword
     * @return
     */
    List<Coach> selectLimitCoach(@Param("start") int start,@Param("end") int end, @Param("keyword") String keyword);



    /**
     * 注册教练
     *
     * @param coach
     */
    void insertCoach(Coach coach);


    /**
     * 注销教练信息
     *
     * @param coachId
     */
    void deleteCoachByID(String coachId);

    void deleteCourseByCoachId(String coachId);
    /**
     * 更新教练消息
     *
     * @param coach
     */
    void updateCoachByID(Coach coach);
}
