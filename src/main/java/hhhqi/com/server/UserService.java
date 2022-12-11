package hhhqi.com.server;

import hhhqi.com.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();  // 查询所有数据
    public  List<User> getLimitUser(int page, int num,String stime,String etime, String idUsername);  // 查询第几页数据，一页数据多少个
    public int updateUserByID(User user);//通过id更新数据
    public int deleteUserByID(int id);//通过id删除数据
    public User checkUserByLogin(String username,String password);//判断是否正确
    public int addUser(User user);//添加用户
}
