package hhhqi.com.server.impl;

import hhhqi.com.entity.User;
import hhhqi.com.dao.UserDao;
import hhhqi.com.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(@Autowired UserDao userDao){
        this.userDao = userDao;
    }


    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    public List<User> getLimitUser(int page, int num, String stime, String etime, String idUsername) {
        return userDao.selectLimitUser((page-1)*num, num,stime,etime,idUsername);
    }

    public int updateUserByID(User user) {
        String dateStr = "";
        if(user.getLastLoginTime() != null)
            dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(user.getLastLoginTime().getTime()));
        System.out.println("update:"+user);
        System.out.println("time:"+dateStr);
        return userDao.updateUserByID(user.getId(),user.getUsername(),user.getPassword(),dateStr,
                user.getLoginCount(),user.getPhone(),user.getAge(),user.getName(),user.getRole());
    }

    public int deleteUserByID(int id) {
        return userDao.deleteUserByID(id);
    }

    public User checkUserByLogin(String username, String password) {
        return userDao.selectUserByLogin(username,password);
    }

    public int addUser(User user) {
        String dateStr = "";
        user.setLastLoginTime(new Timestamp(System.currentTimeMillis()));//最后登陆时间更新
        if(user.getLastLoginTime() != null)
            dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(user.getLastLoginTime().getTime()));
        System.out.println("update:"+user);
        System.out.println("time:"+dateStr);
        return userDao.insertUser(user.getUsername(),user.getPassword(),dateStr,
                user.getPhone(),user.getAge(),user.getName(),user.getRole());
    }

}
