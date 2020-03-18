package cn.eight.employservice.pojo;

/**
 * @author 瞿琮
 * @create 2020-03-18 10:22
 */
public class Sjzd {
    private Integer id;
    private String name;
    private String remarks;
    private Integer sortInt;
    private String sortStr;

    public Sjzd() {
    }

    public Sjzd(Integer id, String name, String remarks, Integer sortInt) {
        this.id = id;
        this.name = name;
        this.remarks = remarks;
        this.sortInt = sortInt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getSortInt() {
        return sortInt;
    }

    public void setSortInt(Integer sortInt) {
        this.sortInt = sortInt;
    }

    public String getSortStr() {
        return sortStr;
    }

    public void setSortStr(String sortStr) {
        this.sortStr = sortStr;
    }
}
