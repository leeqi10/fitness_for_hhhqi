# 健身房管理系统

# 延伸阅读
### 创建顺序：

#### 目前值实现了登录拦截器（没登陆不能get/post），用户数据展示两个模块

+ pojo实体类。可以在数据库右键表名，直接添加实体类。[点击展示图片](src/main/resources/read.img/img.png)
  ![图示](src/main/resources/read.img/img.png)
+ dao数据库mapper处理。 添加注解@Mapper后，可以注解添加语句，可以配置xml添加sql语句。[示例](Products/Idea_java/fitness_for_hhhqi/src/main/java/hhhqi/com/dao/UserDao.java)
+ server再处理dao得到的数据，或者设计新的函数。
+ controller网页数据处理、拦截器等。数据处理: server也可以做。比如说处理得到的用户user数据，密码需要改为***，再传给服务器。或者layui需要得到指定格式的json数据，需要先得到数据库数据，再改为需要格式，才能传给服务器。
拦截器：比如说登陆了才能访问各种数据，避免没有登录也能处理数据等。

## 数据库数据自动添加

可以通过navicat自动添加测试数据[点击展示图片](src/main/resources/read.img/img2.png)

![图示](src/main/resources/read.img/img2.png)

## POST测试工具，POSTMAN: https://www.postman.com/downloads/


course 里通过名字与 coach绑定的  已经做得差不多了  难以修改
  
只有增删改查基础已经完成，别的有待完善

数据库配置在resource下的application.propertis里，数据库文件为sql/fitness.sql,数据库名字应该为fitness
