package hhhqi.com.dao;

import hhhqi.com.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    public List<User> selectAllUser();  // 查询所有数据



    public  List<User> selectLimitUser(@Param("start") int start,@Param("end") int end,@Param("stime") String stime,
                                       @Param("etime") String etime,@Param("idUsername") String idUsername);  // 查询start到end数据[start,end)

    public int updateUserByID(@Param("id")long id,@Param("username")String username,@Param("password")String passowrd,
                              @Param("time")String time,@Param("loginCount")long loginCount,@Param("phone")String phone,
                              @Param("age")long age,@Param("name")String name,@Param("role")String role);
    public int deleteUserByID(@Param("id") int id);

    public User selectUserByLogin(@Param("username")String username,@Param("password")String password);
//    @Insert("insert into user value(username=#{username},password=#{password},last_login_time=#{lastLoginTime}," +
//            "login_count=#{loginCount},phone=#{phone},age=#{age},name=#{name},role=#{role})")

    public int insertUser(@Param("username")String username,@Param("password")String passowrd,
                          @Param("time")String time,@Param("phone")String phone,
                          @Param("age")long age,@Param("name")String name,@Param("role")String role);


}
