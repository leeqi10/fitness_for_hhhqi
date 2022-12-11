package hhhqi.com.server;

import hhhqi.com.entity.Member;
import hhhqi.com.entity.Result;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 会员业务层接口
 * @create: 2022-11-26 09:17
 **/
public interface MemberService {

    Result getMembersAll();
    /**
     * 分页查询会员数据
     * @param startPage 起始页码
     * @param pageSize 页码大小
     * @return
     */
    Result getMemberByPage(Integer startPage, Integer pageSize, String memberId, String memberName);

    /**
     * 注销会员
     * @param id
     * @return
     */
    Result deleteMember(String id);

    /**
     * 修改会员信息
     * @param member
     * @return
     */
    Result updateMember(Member member);

    /**
     * 注册会员
     * @param member
     * @return
     */
    Result insertMember(Member member);



}
