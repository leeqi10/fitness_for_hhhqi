package hhhqi.com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @program: gym-management-system
 * @author: GUMP
 * @description: 会员实体类
 * @create: 2022-11-18 22:55
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
    //会员id  自增
    private Integer memberId;

    //会员编号
    private String memberNumber;


    //会员密码
    private String memberPassword;

    //会员姓名
    private String memberName;

    //会员性别
    private String memberSex;

    //会员类型
    private String memberType;

    //会员生日
    private Timestamp memberBirth;

    //联系电话
    private String memberPhone;

    //住址
    private String memberAddress;

    //初始时间
    private Timestamp memberStartTime;

    //到期时间
    private Timestamp memberEndTime;

}
