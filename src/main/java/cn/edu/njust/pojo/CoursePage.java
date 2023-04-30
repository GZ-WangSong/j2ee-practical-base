package cn.edu.njust.pojo;

import java.util.List;

public class CoursePage {
    private int currentPage;
    private int pageSize;
    private List<Course> arrayList;
    private int totalCount;
    private int Sum;

    public CoursePage() {
        super();
    }

    public CoursePage(int currentPage, int pageSize,
                      List<Course> arrayList, int totalCount, int sum) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.arrayList = arrayList;
        this.totalCount = totalCount;
        Sum = sum;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Course> getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<Course> arrayList) {
        this.arrayList = arrayList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getSum() {
        return Sum;
    }

    public void setSum(int sum) {
        Sum = sum;
    }

}
