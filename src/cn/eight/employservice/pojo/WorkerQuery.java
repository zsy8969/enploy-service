package cn.eight.employservice.pojo;

public class WorkerQuery {
    private String name;
    private String sex;
    private String age1;
    private String age2;
    private String worktime;
    private String edu;
    private String[] hobbit;
    private String[] luange;
    private String luange1;
    private String statu;
    private String otherstatu;
    private String merry;
    private String othermerry;
    private String[] pic;
    private String[] skill;
    private String otherskill;

    public WorkerQuery() {
    }

    public WorkerQuery(String name, String sex, String age1, String age2, String worktime, String edu, String[] hobbit, String[] luange, String luange1, String statu, String otherstatu, String merry, String othermerry, String[] pic, String[] skill, String otherskill) {
        this.name = name;
        this.sex = sex;
        this.age1 = age1;
        this.age2 = age2;
        this.worktime = worktime;
        this.edu = edu;
        this.hobbit = hobbit;
        this.luange = luange;
        this.luange1 = luange1;
        this.statu = statu;
        this.otherstatu = otherstatu;
        this.merry = merry;
        this.othermerry = othermerry;
        this.pic = pic;
        this.skill = skill;
        this.otherskill = otherskill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge1() {
        return age1;
    }

    public void setAge1(String age1) {
        this.age1 = age1;
    }

    public String getAge2() {
        return age2;
    }

    public void setAge2(String age2) {
        this.age2 = age2;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String[] getHobbit() {
        return hobbit;
    }

    public void setHobbit(String[] hobbit) {
        this.hobbit = hobbit;
    }

    public String[] getLuange() {
        return luange;
    }

    public void setLuange(String[] luange) {
        this.luange = luange;
    }

    public String getLuange1() {
        return luange1;
    }

    public void setLuange1(String luange1) {
        this.luange1 = luange1;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getOtherstatu() {
        return otherstatu;
    }

    public void setOtherstatu(String otherstatu) {
        this.otherstatu = otherstatu;
    }

    public String getMerry() {
        return merry;
    }

    public void setMerry(String merry) {
        this.merry = merry;
    }

    public String getOthermerry() {
        return othermerry;
    }

    public void setOthermerry(String othermerry) {
        this.othermerry = othermerry;
    }

    public String[] getPic() {
        return pic;
    }

    public void setPic(String[] pic) {
        this.pic = pic;
    }

    public String[] getSkill() {
        return skill;
    }

    public void setSkill(String[] skill) {
        this.skill = skill;
    }

    public String getOtherskill() {
        return otherskill;
    }

    public void setOtherskill(String otherskill) {
        this.otherskill = otherskill;
    }
}
