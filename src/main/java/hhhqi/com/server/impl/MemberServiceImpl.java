package hhhqi.com.server.impl;

import hhhqi.com.dao.MemberMapper;
import hhhqi.com.entity.Member;
import hhhqi.com.entity.Result;
import hhhqi.com.server.MemberService;
import hhhqi.com.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 会员服务层实现
 * @create: 2022-11-27 11:24
 **/
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;


    public MemberServiceImpl(@Autowired MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public Result getMembersAll(){
        List<Member> members = memberMapper.getAllMember();
        return new Result(Result.OK, "查询成功", members.size(), members);
    }

    public Result getMemberByPage(Integer page, Integer num, String memberId, String memberName) {
        List<Member> members = memberMapper.getMemberByPage((page-1)*num, num, memberId, memberName);
        return new Result(Result.OK, "查询成功", memberMapper.getMemberByPage(0, 1000000, memberId, memberName).size(), members);
    }

    public Result deleteMember(String id) {
        int num = memberMapper.deleteMember(id);
        return new Result(Result.OK,"删除成功",num,num);
    }

    public Result updateMember(Member member) {
        int num = memberMapper.updateMember(member);
        return new Result(Result.OK,"修改成功",num,num);
    }

    public Result insertMember(Member member) {
        member.setMemberNumber(Md5Util.getMD5String(member.getMemberId().toString().substring(0,20)));
        int num = memberMapper.insertMember(member);
        return new Result(Result.OK,"注册成功",num,num);
    }


}
