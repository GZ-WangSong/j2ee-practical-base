package cn.edu.njust.pojo;

public class Login {
    private int id;
    private String name;
    private String password;
    private String school;
    private String department;

    public Login() {
    }

    public Login(String name, String password, String school, String department) {
        super();
        this.name = name;
        this.password = password;
        this.school = school;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
