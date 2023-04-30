# J2EE实用基础

## 1 前言

最初本来不打算建立这个仓库，代码以压缩包的形式存储于网盘之中，建立这个仓库的原因，是在准备复习一下JDBC的使用的时候，打开学习这个课程的压缩包，一个7次作业，加上一次最后的考核项目，8个压缩包放在一起，一个一个的解压，打开之后发现曾经的代码，真是不堪入目，不知道曾经老师怎么就便宜了我，还给了我优秀的评分。

所以准备重新整理一下曾经的代码，尽量不改变原本的代码，只做优化，熟悉一下之前基本的知识点。

本次采用Maven构建项目，以前是在一个老版本的MyEclipse上建立的项目，个人体验不是很好，而且一个项目代码在不同IDE之间移植导入简直是十分恶心的。Maven能解决导入问题。

同时这个仓库用于版本的管理，曾经做作业每次都是将上一次的作业拷贝一份，复制粘贴代码，最让人无语的就是，项目名称得按照老师的要求命名，多个项目名冲突的，有强迫症的我很是难受。其实是当时不会用Git啦！

所以，”工欲善其事必先利其器“，**建议大家还是学学Maven的基本使用，以及Git的基本使用，这会是一笔很划算的买卖。**



## 2 作业具体版本号

> 如果有参考者发现这个糟糕的东西，又想做一下参考，那此处附上版本号，可以直接使用git命名快速切换到对应的作业代码。

1. 第1次作业：`7684cec1994defeba8df12254e166245538b1dba`；
2. 第2次作业：`e88b3523bef2c0082cfcea5dfbe662d055525af3`；
3. 第3次作业：`9c8ef5114fd8bd16922a3dd1cd6b455bd141f3f7`；
4. 第4次作业：`091b4665f1ae61792ad4677786d855b2eac381c7`；
5. 第5次作业：`7ae8f9d71334888f443b8875b0225a9f37a2a287`；
6. 第6次作业：
7. 第7次作业：
8. 期末考核项目：



---





## 3 作业具体要求

### 3.1 第1次作业要求

本次作业只是为了考察大家是否将基本环境搭建完成，即Tomcat服务器是否配置成功，是否能正常使用。

---





### 3.2 第2次作业要求

熟悉HTML标记语言和Servlet编程API文档，设计和开发一个web应用。具体要求如下：
1)	项目名称为“序号-Homework”，web应用名称“Homework_序号”；序号与各自在群里的序号保持一致；
2)	开发一个登录页面login.html，包含一个登录表单，页面如下图所示，其中类别是下拉框，值为“学生”和“辅导员”，点击提交按钮后由LoginServlet进行处理。务必在用户名输入框中填入：学生姓名+学号；完成后部署运行，提交该功能点的截图。
   <img src="https://gitee.com/NJUSTer_songw/my-images/raw/master/image-20230428191656653.png" alt="image-20230428191656653" style="zoom:50%;" />

3)	开发一个登录LoginServlet作为控制器，该servlet首先获取用户提交的信息，包括“用户名”、“密码”、“验证码”和“类别”，其中验证码对应的数值为8774；然后调用LoginService完成业务逻辑处理，具体地，依据验证码加上学生序号num得到的数值调用函数randomInt()，得到返回值result；最后，直接在浏览器中输出：用户名 + 验证码 + 序号 + 获得到的返回值result；提交该功能点的运行截图。例如，序号为5的学生（辛同学），8774+5 = 8779，为奇数，返回的result应该是10~19之间的随机数（假设为12）；页面显示结果为：xx 8774 5 12
4)	开发一个LoginService（普通的java）完成业务逻辑处理，模拟的业务逻辑是产生一个0\~19随机整数，函数原型为int result randomInt(int value)，如果value是偶数，则产生0\~9之间的随机整数，否则产生10\~19之间随机整数;
5)	所有的截图包括URL信息
6)	提交项目文件。
7)	提交截止日期：2022年3月6日晚8点

---



### 3.3 第3次作业要求

熟悉HTML标记语言和Servlet编程API文档，设计和开发一个web应用。具体要求如下：

1. 项目名称为“序号-Homework”，web应用名称“Homework_序号”；序号与各自在群里的序号保持一致；

2. 熟悉ServletConfig和ServletContext编程接口。创建一个servlet名为“HelloWorldServlet”，为该servlet设置两个初始化参数，参数名分别为name和student_no，参数值分别为“学生姓名”和“学号”（每个同学使用自己的姓名和学号）；为该应用程序设置一个初始化参数，参数名为course，参数值为“JavaEE实用基础”。运行该servlet，输出格式为

   ```txt
   我是学号为#student_no的#name同学，
   这是从#course中学习到的一个简单servlet程序
   ```

**提交该功能点的截图**。

3. 创建SharedServlet，实现下列功能：

   a) 通过ServletContext获得web应用参数，参数id，值为“各自的序号”，读取参数值；

   b) 通过ServletContext绑定一个对象，该对象保存int类型的数，值为参数id的数值+1；

   c) 通过HttpSession绑定一个对象，该对象保存int类型的数，值为参数id的数值+2。创建ValidateSharedServlet，设计若干个场景，描述清楚ServletContext和HttpSession作为容器对象的差异。开放式命题，到达识别差异为目标，若有必要，可以额外增加web资源。**提交该功能点的截图（可以不止一个截图）**。

4. 开发一个包含学生选课情况汇总表的页面course.jsp，表格如下所示，提交该功能点的截图。

<img src="https://gitee.com/NJUSTer_songw/my-images/raw/master/clip_image002.jpg" alt="img" style="zoom:60%;" />

5. 所有的截图包括URL信息
6. 提交项目文件。
7. 提交截止日期：2022年3月15日晚8点

---



### 3.4 第4次作业要求

熟悉HTML标记语言、Servlet编程API文档、JSP页面元素和MVC设计模式，设计和开发一个基于MVC的web应用。具体要求如下：

1. 项目名称为“序号-Homework”，web应用名称“Homework_序号”；序号与各自在群里的序号保持一致；

2. 实现登录功能

   1. 创建3个jsp页面，分别为login.jsp、main.jsp和loginFailure.jsp

      i.	login.jsp 负责实现登录表单，包括用户名、密码和验证码，“所在学院”【下拉列表】、“所在系”【下拉列表】，要求实现系与学院的联动，即选择的学院改变所在系的选项也同步变化（学习javascript，可以实现该联动功能）；

![image-20230429110532782](https://gitee.com/NJUSTer_songw/my-images/raw/master/image-20230429110532782.png)

​               ii.	loginFailure 负责给出登录失败的原因描述，并能跳转到login.jsp进行重新登录。

​               iii.	main.jsp 负责实现提示登录成功，5秒钟后自动跳转到course.jsp页面（course.jsp沿用已完成的第3次作业对应页面）

- 创建1个实体类Login，封装用户名、密码等信息；
- 创建1个登录业务逻辑处理类LoginService，实现登录业务逻辑处理；
- 创建1个用户数据访问类UserDAO，读写用户数据，可以正常登录的用户登录信息可以在UserDAO进行设定，无需访问数据库（后续会扩展）；
- 创建1个servlet，名为LoginController，负责实现控制器功能，完成请求数据获取和封装、将请求分发到业务逻辑处理对象LoginService（实现登录逻辑），并根据业务处理结果确定何时的结果展示页面：main.jsp（登录成功）或loginFailure.jsp（登录失败，给出原因）。

3. 开发一个包含学生选课情况汇总表的页面course.jsp，表格如下所示，提交该功能点的截图。

<img src="https://gitee.com/NJUSTer_songw/my-images/raw/master/clip_image002.jpg" alt="img" style="zoom:60%;" />

4. 所有的截图包括URL信息，截图不要打包到项目文件中，单独以图片形式上传。

5. 提交项目文件。

6. 提交截止日期：2022年3月22日晚8点

---

### 3.5 第5次作业要求

熟悉HTML标记语言、Servlet编程API文档、JSP页面元素和MVC设计模式，设计和开发一个基于MVC的web应用。具体要求如下：
1)	项目名称为“序号-Homework”，web应用名称“Homework_序号”；序号与各自在群里的序号保持一致；
2)	采用mysql作为数据库服务器，创建数据库，名为“序号_JDBC”，创建2张表user和course.表user的关系模式为：user(uId, uName, uPw, uSchool, uDepartment); 表course(cId, cName, cNum, cType); 表中涉及的字段数据类型自行设定，但要确保合理；创建完成后预先插入数据，表user不少于3个用户，表course不少于10门课程。提交该功能点的截图。
3)	在第4次作业基础上，按照要求优化代码逻辑【要求参照群文件“示例代码”和“MVC-更新.png”】，重新实现登录功能，提交必要的截图

- 创建3个jsp页面，分别为login.jsp、main.jsp和loginFailure.jsp 【所有页面为中文】
  i.	login.jsp 负责实现登录表单，包括用户名、密码和验证码，“所在学院”【下拉列表】、“所在系”【下拉列表】，要求实现系与学院的联动，即选择的学院改变所在系的选项也同步变化（学习javascript，可以实现该联动功能）；

![image-20230429110532782](https://gitee.com/NJUSTer_songw/my-images/raw/master/image-20230429110532782.png)

​	ii.	loginFailure 负责给出登录失败的原因描述，并能跳转到login.jsp进行重新登录。
​	iii.	main.jsp 负责实现提示登录成功，5秒钟后自动跳转到allCourse.jsp页面。【交给CourseController处理，allCourse.jsp和CourseController见要求4】

- 创建1个实体类Login，封装用户名、密码等信息；
- 创建1个登录业务逻辑处理类LoginService，实现登录业务逻辑处理；
- 创建1个用户数据访问类UserDAO，从数据库表user中读写用户数据，采用JDBC编程，暂不要求使用DButils；
- 创建1个servlet，名为LoginController，负责实现控制器功能，完成请求数据获取和封装、将请求分发到业务逻辑处理对象LoginService（实现登录逻辑），并根据业务处理结果确定合适的结果展示页面：main.jsp（登录成功）或loginFailure.jsp（登录失败，给出原因）。

4)	实现课程管理功能，提交必要截图佐证材料

- 开发一个包含学生选课情况汇总表的页面allCourse.jsp，表格如下所示，登录成功后展示course表中的课程信息；同时，在页面allCourse.jsp增加2个按钮“新增”和“删除”，提交该功能点的截图。

<img src="https://gitee.com/NJUSTer_songw/my-images/raw/master/clip_image002.jpg" alt="img" style="zoom:60%;" />

- 创建页面addCourse.jsp，自行设计该页面的UI，要素包括课程名称、选课人数、课程性质，均支持中文输入；添加成功后跳转到allCourse.jsp，添加失败则跳转到courseFailure.jsp，给出失败原因描述，并提供超链接返回allCourse.jsp；
- 创建页面delCourse.jsp，选中一行或者多行（序号列前的选择框），执行删除成功，给出提示信息，而后跳转到allCourse.jsp，删除失败则跳转到courseFailure.jsp，给出失败原因描述，并提供超链接返回allCourse.jsp；
- 创建1个实体类Course，封装课程信息；
- 创建1个课程管理业务逻辑处理类CourseService，实现课程相关业务逻辑处理；
- 创建1个课程数据访问类CourseDAO，从数据库表course中读写课程信息，采用JDBC编程，暂不要求使用DButils；
- 创建1个servlet，名为CourseController，负责实现控制器功能，完成请求的数据获取和封装、将请求分发到业务逻辑处理对象CourseService，并根据业务处理结果确定合适的结果展示页面：allCourse.jsp或courseFailure.jsp。

5. 资源组织合理，参见群文件“示例代码”的组织方式，或者按照功能点组织；

6. 所有的运行截图包括URL信息，创建word或者pdf文件，将所有截图按照合理的逻辑组织起来放在word或pdf文件中，文件命名方式为“序号-成果展示.docx”或“序号-成果展示.pdf”；

7. 最终提交的产物由2个文件构成：

   1）项目文件；

   2）要求6生成的word或pdf文件；

8. 提交截止日期：2022年3月29日晚8点

---



### 3.6 第6次作业要求

熟悉HTML标记语言、Servlet编程API文档、JSP页面元素和MVC设计模式，设计和开发一个基于MVC的web应用。具体要求如下：
1)	项目名称为“序号-Homework”，web应用名称“Homework_序号”；序号与各自在群里的序号保持一致；
2)	采用mysql作为数据库服务器，创建数据库，名为“序号_JDBC”，创建3张表user，course和hitCourse.表user的关系模式为：user(uId, uName, uPw, uSchool, uDepartment); 表course(cId, cName, cNum, cType); 表hitCourse(uId, cId, score)记录学生选修的课程和课程得分，表中涉及的字段数据类型自行设定，但要确保合理；创建完成后预先插入数据，表user不少于3个用户，表course不少于10门课程。提交该功能点的截图。
3)	在第5次作业基础上，做轻微的改动满足要求【改动之处为红色部分】，提交必要的截图

- 创建3个jsp页面，分别为login.jsp、main.jsp和loginFailure.jsp 【所有页面为中文】
  i.	login.jsp 负责实现登录表单，包括用户名、密码和验证码，“所在学院”【下拉列表】、“所在系”【下拉列表】，要求实现系与学院的联动，即选择的学院改变所在系的选项也同步变化（学习javascript，可以实现该联动功能）；

  ![image-20230429110532782](https://gitee.com/NJUSTer_songw/my-images/raw/master/image-20230429110532782.png)

​	ii.	loginFailure 负责给出登录失败的原因描述，并能跳转到login.jsp进行重新登录。
​	iii.	main.jsp 负责实现提示登录成功，5秒钟后自动跳转到hitCourse.jsp页面。【交给CourseController处理，hitCourse.jsp和CourseController见要求4】

- 创建1个实体类Login，封装用户名、密码等信息；
- 创建1个登录业务逻辑处理类LoginService，实现登录业务逻辑处理；
- 创建1个用户数据访问类UserDAO，从数据库表user中读写用户数据，采用第三方库DButils实现JDBC编程；【DButils见群文件中范例“AdvancedJDBCApp”】
- 创建1个servlet，名为LoginController，负责实现控制器功能，完成请求数据获取和封装、将请求分发到业务逻辑处理对象LoginService（实现登录逻辑），并根据业务处理结果确定合适的结果展示页面：main.jsp（登录成功）或loginFailure.jsp（登录失败，给出原因）。

4)	实现课程管理功能，新增的需求见红色部分，提交必要截图佐证材料

- 开发一个包含学生选课情况汇总表的页面allCourse.jsp，表格如下所示，登录成功后展示course表中的课程信息；同时，在页面allCourse.jsp增加3个按钮“新增”、“删除”和“选课”，提交该功能点的截图。

  <img src="https://gitee.com/NJUSTer_songw/my-images/raw/master/clip_image002.jpg" alt="img" style="zoom:60%;" />

- 创建页面addCourse.jsp，自行设计该页面的UI，要素包括课程名称、选课人数、课程性质，均支持中文输入；添加成功后跳转到allCourse.jsp，添加失败则跳转到courseFailure.jsp，给出失败原因描述，并提供超链接返回allCourse.jsp；
- 创建页面delCourse.jsp，选中一行或者多行（序号列前的选择框），执行删除成功，给出提示信息，而后跳转到allCourse.jsp，删除失败则跳转到courseFailure.jsp，给出失败原因描述，并提供超链接返回allCourse.jsp；
- 创建页面hitCourse.jsp，本页面提取登录成功的用户对应的选课信息，有1个退选按钮，实现课程退选；1个课程管理按钮，调转到allCourse.jsp, 页面显示如下：

<img src="https://gitee.com/NJUSTer_songw/my-images/raw/master/image-20230430102237079.png" alt="image-20230430102237079" style="zoom:70%;" />

- 创建1个实体类Course，封装课程信息；
- 创建1个实体类HitCourse，封装选课信息，包括uId，uName，cId，cName，score；
- 创建1个课程管理业务逻辑处理类CourseService，实现课程相关业务逻辑处理，包括新增课程、删除课程，选修课程，退选课程；值得注意的是：选修课程，退选课程会影响course信息中选课人数，不允许重复选择同一门课程，需要实现上述选课，退选逻辑。
- 创建1个课程数据访问类CourseDAO，从数据库表course中读写课程信息，采用第三方库DButils实现JDBC编程；
- 创建1个课程选修数据访问类HitCourseDAO，从数据库表hitCourse中读写选课信息，采用第三方库DButils实现JDBC编程；
- 创建1个servlet，名为CourseController，负责实现控制器功能，完成请求的数据获取和封装、将请求分发到业务逻辑处理对象CourseService，并根据业务处理结果确定合适的结果展示页面：allCourse.jsp、hitCourse.jsp、courseFailure.jsp。

5)	资源组织合理，参见群文件“示例代码”的组织方式，或者按照功能点组织；
6)	所有的运行截图包括URL信息，创建word或者pdf文件，将所有截图按照合理的逻辑组织起来放在word或pdf文件中，文件命名方式为“序号-成果展示.docx”或“序号-成果展示.pdf”；
7)	最终提交的产物由2个文件构成：1）项目文件；2）要求6生成的word或pdf文件；
8)	提交截止日期：2022年4月6日晚8点



---



## 4 建表语句

```SQL
select database();

create database if not exists 59_JDBC;

CREATE TABLE `user`
(
    `uId`         int(11) NOT NULL,
    `uName`       varchar(30) DEFAULT NULL,
    `uPw`         varchar(30) DEFAULT NULL,
    `uSchool`     varchar(50) DEFAULT NULL,
    `uDepartment` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`uId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户表';

CREATE TABLE `course`
(
    `cId`   varchar(10) primary key ,
    `cName` varchar(50),
    `cNum`  int,
    `cType` varchar(10)
)COMMENT = '课程表';

# drop table course;

INSERT INTO course values ('06029903','WEB技术与应用',80,'选修');
INSERT INTO course values ('06027801','J2EE实用基础',100,'选修');
INSERT INTO course values ('06020102','计算机网络',80,'必修');
INSERT INTO course values ('06022404','数据结构',80,'必修');
INSERT INTO course values ('04026806','模拟电子线路',80,'必修');
INSERT INTO course values ('06030702','计算机逻辑基础',80,'必修');
INSERT INTO course values ('36400002','形势与政策',80,'必修');
INSERT INTO course values ('06023102','算法设计与分析',80,'必修');
INSERT INTO course values ('14220701','进阶英语(II)',80,'必修');
INSERT INTO course values ('21420102','体育(IV)',80,'必修');
INSERT INTO course values ('00004201','普通话语音训练',80,'选修');



CREATE TABLE hit_course
(
    `uId`   int(11) NOT NULL,
    `cId`   varchar(10),
    `score` FLOAT
) COMMENT ='选课表';

INSERT INTO hit_course values (1,'06029903',80);
INSERT INTO hit_course values (1,'21420102',80);
INSERT INTO hit_course values (1,'00004201',80);
INSERT INTO hit_course values (2,'06029903',80);
INSERT INTO hit_course values (3,'06029903',80);


```

