package hhhqi.com.controller;

import hhhqi.com.entity.Coach;
import hhhqi.com.entity.Result;
import hhhqi.com.server.CoachService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 教练控制层
 * @create: 2022-11-20 16:31
 **/

@RestController
@RequestMapping("/coach")
@Api(value = "User", tags = "用户")
public class CoachController {

    private final CoachService coachService;


    public CoachController(@Autowired CoachService coachService) {
        this.coachService = coachService;
    }

    /**
     * 分页查询教练信息
     *
     * @param startPage 起始页码
     * @param pageSize  页码容量
     * @return 数据集合
     */
    @GetMapping("/chaXunFenYe")
    public Result getCoachByPage(@RequestParam("page") String startPage,
                                                  @RequestParam("limit") String pageSize,
                                                  @RequestParam("keyword") String keyword) {
        return coachService.selectLimitCoach(Integer.valueOf(startPage), Integer.valueOf(pageSize), keyword);
    }

    /**
     * 注册教练，教练认证
     *
     * @param coach 教练信息
     * @return
     */
    @PostMapping("/xinZeng")
    public Result insertCoach(Coach coach) {
        return coachService.insertCoach(coach);
    }

    /**
     * 更新教练信息
     * @param coach 教练信息
     * @return
     */
    @PutMapping("/gengXinById")
    public Result updateCoach(Coach coach) {
        return coachService.updateCoachByID(coach);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/shanChuById")
    public Result deleteCoach(@RequestParam("coachId") String id){
        return coachService.deleteCoachByID(id);
    }


}
