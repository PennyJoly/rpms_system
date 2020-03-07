package cn.itsource.basic.query;

public class BaseQuery {
    private Long page;
    //默认为每页10张数据
    private Long pageSize=10L;
    //查询关键字
    private String name;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStart(){
        return (this.page-1)*pageSize;
    }
}
