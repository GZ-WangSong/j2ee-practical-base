<%--
  Created by IntelliJ IDEA.
  User: NJUST'er'wang's
  Date: 2023/4/29
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<form action="loginController" method="post" name="form1">
    用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户：<input type="text" name="name"><BR>
    密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="pwd"><BR>
    验&nbsp;证&nbsp;码：&nbsp;<input type="text" name="safeCode">&nbsp;8774<br>
    所在学院：
    <select name="school" onChange="getDepartment()">
        <option value="0">请选择所在学院</option>
        <option value="计算机科学与工程学院">计算机科学与工程学院</option>
        <option value="电子工程与光电技术学院">电子工程与光电技术学院</option>
    </select><br>
    所&nbsp;在&nbsp;系：
    <select name="department">
        <option value="0">请选择所在系</option>
    </select><br>
    <input type="submit" value="登录">
    <span style="color: purple; ">&nbsp;&nbsp;帮助 &nbsp;&nbsp;忘密</span>
</form>


<script>
    //定义了专业的二维数组，里面的顺序跟学院的顺序是相同的。通过selectedIndex获得学院的下标值来得到相应的专业数组
    const department = [
        ["计算机科学与技术", "软件工程", "智能科学与技术", "网络空间安全"],
        ["电子信息工程", "通信工程", "电子科学技术", "光电信息科学与工程"]
    ];

    function getDepartment() {
        //获得学院下拉框的对象
        let sltSchool = document.form1.school;
        //获得系下拉框的对象
        let sltDepartment = document.form1.department;

        //得到对应学院的专业数组
        let schoolDepartment = department[sltSchool.selectedIndex - 1];

        //清空专业下拉框，仅留提示选项
        sltDepartment.length = 1;

        //将专业数组中的值填充到学院下拉框中
        for (let i = 0; i < schoolDepartment.length; i++) {
            //Option(选项描述，选项值) 等价于 <option value="选项值" >选项描述</option>;
            sltDepartment[i + 1] = new Option(schoolDepartment[i], schoolDepartment[i]);
        }
    }
</script>
</body>
</html>
