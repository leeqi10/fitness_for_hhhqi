package hhhqi.com.controller;

import hhhqi.com.entity.Member;
import hhhqi.com.entity.Result;
import hhhqi.com.server.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 会员控制器
 * @create: 2022-11-29 10:09
 **/
@RestController
@RequestMapping("/member")
@ResponseBody
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService=memberService;
    }

    /**
     * 分页获取会员信息
     * @param startPage
     * @param pageSize
     * @return
     */
    @GetMapping("/select")
    public Result getMemberByPage(@RequestParam("page")Integer startPage,
                                  @RequestParam("limit") Integer pageSize,
                                  @RequestParam("memberNumber")String memberNumber,
                                  @RequestParam("memberName") String memberName){
        return memberService.getMemberByPage(startPage,pageSize,memberNumber,memberName);
    }

    /**
     * 注册会员
     * @param member
     * @return
     */
    @PostMapping("/insert")
    public Result insertMember(Member member){
        return memberService.insertMember(member);
    }

    /**
     * 更新会员信息
     * @param member
     * @return
     */
    @PutMapping("/update")
    public Result updateMember(Member member){
        return memberService.updateMember(member);
    }

    /**
     * 注销会员
     * @param id
     * @return
     */
    @DeleteMapping ("/delete")
    public Result deleteMember(@RequestParam("memberId")String id){
        return memberService.deleteMember(id);
    }

}
