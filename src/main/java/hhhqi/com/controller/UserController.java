package hhhqi.com.controller;

import com.alibaba.fastjson.JSONArray;
import hhhqi.com.entity.Result;
import hhhqi.com.entity.User;
import hhhqi.com.server.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/user")
 public class UserController {
    private final UserServiceImpl userServiceImpl;

    public UserController(@Autowired UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    static int max=1000000;


    //得到所有user
    @GetMapping("/chaXunAll")
    public String getAllUser(){
        List<User> list = userServiceImpl.getAllUser();
        System.out.println("data"+list);
        for(User x:list){
            x.setPassword("********");
        }
        Result message = new Result<>(0,"", list.size(),list);
        String data = JSONArray.toJSONString(message);
        return data;
    }

    //得到分页数据  PathVariable路径得到值
    @GetMapping("/chaXunFenYe")
    public String getLimitUser(@RequestParam("page")int page,@RequestParam("limit") int num,
                               @RequestParam("stime") String stime,
                               @RequestParam("etime") String etime,
                               @RequestParam("idUsername") String idUsername){
        System.out.println("Page:"+page+"num:"+num+"stume:"+changstamp(stime)+"etiem:"+changstamp(etime)+"idu:"+idUsername);
        System.out.println("Page:"+page+"num:"+num+"stume:"+stime+"etiem:"+etime+"idu:"+idUsername);
        List<User> list = userServiceImpl.getLimitUser(page, num, changstamp(stime),changstamp(etime),"%"+idUsername.trim()+"%");
        for(User x:list){
            x.setPassword("********");
        }
        Result result = new Result(0,"",userServiceImpl.getLimitUser(1,max,
                changstamp(stime),changstamp(etime),"%"+idUsername.trim()+"%").size(),list);
        String data = JSONArray.toJSONString(result);
        return data;
    }//得到分页数据  PathVariable路径得到值

    //更新数据,更新一般用put  RequestBody表单得到
    @PutMapping("/gengXinById")
    public int updateUser(User user){
        //System.out.println(userJSON);//userServiceImpl.addUser((User)userJSON);
        int num = userServiceImpl.updateUserByID(user);
        return num;
    }

    //插入数据，一般用post
    @PostMapping("/xinZeng")
    public int insertUser(User user){
        System.out.println(user);//
        int num = userServiceImpl.addUser(user);
        return num;
    }

    //登录验证
    @PostMapping(value = "/login")
    public Result checkLoginUser(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response, HttpServletRequest request){
//        System.out.println(username+password+"user:password");
        Result result = new Result();
        User user_check = userServiceImpl.checkUserByLogin(username.trim(), password.trim());
        if(user_check != null ){ //登录成功
            System.out.println("old:"+user_check.toString());
            user_check.setLoginCount(user_check.getLoginCount()+1);     //登录次数加一
            user_check.setLastLoginTime(new Timestamp(System.currentTimeMillis()));//最后登陆时间更新
            System.out.println("new:"+user_check.toString());
            userServiceImpl.updateUserByID(user_check);
            request.getSession().setAttribute("user", user_check);
            user_check.setPassword(""); //密码为空然后返回个人数据
            result = new Result(0,"登录成功",1, JSONArray.toJSONString(user_check));
//            System.out.println(result);
            return result;
        }

        //登录失败
        result.setCode(0);
        result.setCount(0);
        result.setMsg("登录失败");
        result.setData(null);
        return result;
    }


    @PostMapping(value = "/exit")
    public void exitLogin(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return;
    }

    @DeleteMapping("/shanChuById/{id}")
    public int deleteUserById(@PathVariable int id){
        return userServiceImpl.deleteUserByID(id);
    }


    public static String changstamp(String timestamp) {
        if (timestamp == null || timestamp.trim().equals("") || timestamp.trim().equals("NaN") ){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long date_temp = Long.parseLong(timestamp);
        return sdf.format(new Date(date_temp));
    }

}
