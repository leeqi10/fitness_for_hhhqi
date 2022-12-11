package hhhqi.com.controller;

import hhhqi.com.entity.PayProject;
import hhhqi.com.entity.Result;
import hhhqi.com.server.impl.PayProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 付费项目控制层
 * @create: 2022-11-29 11:15
 **/
@RestController
@ResponseBody
@RequestMapping("/payProject")
public class PayProjectController {


    private final PayProjectService payProjectService;


    public PayProjectController(@Autowired PayProjectService payProjectService) {
        this.payProjectService = payProjectService;
    }

    /**
     * 分页查询
     *
     * @param startPage
     * @param pageSize
     * @return
     */
    @GetMapping("/select")
    public Result showPayProject(@RequestParam("page") Integer startPage,
                                                       @RequestParam("limit") Integer pageSize,
                                                       @RequestParam("projectName") String projectName,
                                                       @RequestParam("projectPrice")String projectPrice) {
        return payProjectService.getPayProjectByPage(startPage, pageSize, projectName, projectPrice);
    }



    /**
     * 插入数据
     *
     * @param payProject
     * @return
     */
    @PostMapping("/insert")
    public Result insertPayProject(PayProject payProject) {
        return payProjectService.insertPayProject(payProject);
    }

    /**
     * 通过id删除
     *
     * @param projectId
     * @return
     */
    @DeleteMapping ("/delete")
    public Result deletePayProject(@RequestParam("projectId") String projectId) {
        return payProjectService.deletePayProject(projectId);
    }

    /**
     * 更新数据
     *
     * @param payProject
     * @return
     */
    @PutMapping("/update")
    public Result updatePayProject(PayProject payProject) {
        return payProjectService.updatePayProject(payProject);
    }

}
