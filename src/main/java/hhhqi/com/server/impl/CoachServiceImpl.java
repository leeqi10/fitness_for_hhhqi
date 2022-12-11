package hhhqi.com.server.impl;

import hhhqi.com.dao.CoachMapper;
import hhhqi.com.entity.Coach;
import hhhqi.com.entity.Result;
import hhhqi.com.server.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 教练业务类实现
 * @create: 2022-11-27 10:33
 **/
@Service
public class CoachServiceImpl implements CoachService {
    @Autowired
    private CoachMapper coachMapper;

    @Transactional
    public Result getAllCoach() {
        List<Coach> allCoaches=coachMapper.getAllCoach();
        return new Result(Result.OK,"查询成功", allCoaches.size(),allCoaches);
    }

    @Transactional
    public Result selectLimitCoach(Integer page, Integer num, String keyword) {
        List<Coach> allCoaches=coachMapper.selectLimitCoach((page-1)*num, num, keyword);
        return new Result(Result.OK,"查询成功",coachMapper.selectLimitCoach(0, 1000000, keyword).size(), allCoaches);
    }


    @Transactional
    public Result insertCoach(Coach coach) {
        if(coach.getCoachHeader()==null){
            coach.setCoachHeader("error.png");
        }
        coachMapper.insertCoach(coach);
        return new Result(Result.OK,"新增成功", 1,null);
    }

    @Transactional
    public Result updateCoachByID(Coach coach) {
        coachMapper.updateCoachByID(coach);
        return new Result(Result.OK,"修改成功", 1,null);
    }

    @Transactional
    public Result deleteCoachByID(String id) {
        coachMapper.deleteCoachByID(id);
        coachMapper.deleteCourseByCoachId(id);
        return new Result(Result.OK,"删除成功", 1,null);
    }
}
