package hhhqi.com.dao;

import hhhqi.com.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 会员持久层接口
 * @create: 2022-11-18 22:49
 **/
@Mapper
public interface MemberMapper {

    /**
     * 获取所有会员信息
     * @return 会员集合
     */
    List<Member> getAllMember();


    /**
     * 模糊查询会员信息
     * @param
     * @return 所匹配的会员结果
     */
    List<Member> getMemberByPage(@Param("start") int start, @Param("end") int end, @Param("memberNumber") String memberNumber, @Param("memberName") String memberName);


    /**
     * 新增会员
     * @param member
     */
    int insertMember(Member member);


    /**
     * 根据会员id修改会员信息
     * @param member
     */
    int updateMember(Member member);

    /**
     * 根据会员id删除会员
     * @param memberId
     */
    int deleteMember(String memberId);


}
