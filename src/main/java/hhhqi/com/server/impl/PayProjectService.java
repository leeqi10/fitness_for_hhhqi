package hhhqi.com.server.impl;

import hhhqi.com.dao.PayProjectMapper;
import hhhqi.com.entity.PayProject;
import hhhqi.com.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 项目服务层
 * @create: 2022-11-26 11:27
 **/
@Service
public class PayProjectService {

    @Autowired
    PayProjectMapper payProjectMapper;

    @Transactional
    public Result getPayProjectByPage(Integer startPage, Integer pageSize,String projectName,String projectPrice) {
        Result result = new Result<>();
        List<PayProject> payProjectList = payProjectMapper.selectPayProjectByPage((startPage-1)*pageSize, pageSize, projectName,projectPrice);
        result.setCode(Result.OK);
        result.setMsg("项目列表查询成功");
        result.setCount(payProjectMapper.selectPayProjectByPage(0, 1000000, projectName,projectPrice).size());
        result.setData(payProjectList);
        return result;
    }


    @Transactional
    public Result insertPayProject(PayProject payProject) {
        Result result = new Result<>();
        if (payProject.getProjectName() == null) {
            result.setCode(Result.ERROR);
            result.setMsg("项目名称不能为空");
            return result;
        }
        if (payProject.getProjectPrice() == null) {
            result.setCode(Result.ERROR);
            result.setMsg("项目价格不能为空");
            return result;
        }

        int data = payProjectMapper.insertPayProject(payProject);
        result.setCode(Result.OK);
        result.setMsg("新增项目成功");
        result.setCount(1);
        result.setData(data);
        return result;
    }

    @Transactional
    public Result deletePayProject(String id) {
        Result<?> result = new Result<>();
        payProjectMapper.deletePayProject(Integer.valueOf(id));
        result.setCode(Result.OK);
        result.setMsg(":删除项目成功！");
        return result;
    }

    public Result updatePayProject(PayProject payProject) {
        System.out.println("succes:"+payProject);
        payProject.setProjectPrice(payProject.getProjectPrice());
        Result result = new Result<>();
        if (payProject.getProjectName() == null) {
            result.setCode(Result.ERROR);
            result.setMsg("项目名称不能为空");
            return result;
        }
        if (payProject.getProjectPrice() == null) {
            result.setCode(Result.ERROR);
            result.setMsg("项目价格不能为空");
            return result;
        }
        int data = payProjectMapper.updatePayProject(payProject);
        result.setCode(Result.OK);
        result.setMsg("更新项目成功");
        result.setCount(1);
        result.setData(data);
        return result;
    }


}
