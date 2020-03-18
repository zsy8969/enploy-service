package cn.eight.employservice.pojo;

/**
 * @author 瞿琮
 * @create 2020-03-18 10:22
 */
public class Sjzd {
    private int id;
    private String name;
    private String remarks;
    private int sort;

    public Sjzd() {
    }

    public Sjzd(int id, String name, String remarks, int sort) {
        this.id = id;
        this.name = name;
        this.remarks = remarks;
        this.sort = sort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
