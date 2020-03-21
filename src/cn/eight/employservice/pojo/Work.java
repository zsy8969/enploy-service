package cn.eight.employservice.pojo;

/**
 * @author 瞿琮
 * @create 2020-03-21 10:14
 */
public class Work {
    private int work_id;
    private String work_name;
    private String sex;
    private String idcard;
    private String date;//出生日期
    private Integer age;
    private Integer high;
    private String mphone;//手机
    private String phone;//电话
    private String work_type;//工种
    private String work_time;//从业时间
    private String flwa;// 缺陷
    private String pic;//照片
    private String address;//户籍地址
    private String nowaddress;//现住址
    private String bank_id;
    private String insruid;//保险单号
    private String languge;//语言
    private String status;//状态
    private Character marry;//婚姻状态
    private String pic_status;//证照状态
    private String health;//体检情况
    private String health_dime;//体检时间
    private String skill;//个人技能
    private String self;//自我介绍
    private String time_re;//时间要求
    private String price_re;//工资要求
    private String stay;//住宿
    private String bite;//餐饮
    private String enter_time;//录入时间
    private Integer com_id;//所属公司
    private String edu;

    public Work() {
    }

    public Work(int work_id, String work_name, String sex, String idcard, String date, Integer age, Integer high, String mphone, String phone, String work_type, String work_time, String flwa, String pic, Integer com_id, String edu) {
        this.work_id = work_id;
        this.work_name = work_name;
        this.sex = sex;
        this.idcard = idcard;
        this.date = date;
        this.age = age;
        this.high = high;
        this.mphone = mphone;
        this.phone = phone;
        this.work_type = work_type;
        this.work_time = work_time;
        this.flwa = flwa;
        this.pic = pic;
        this.com_id = com_id;
        this.edu = edu;
    }

    public int getWork_id() {
        return work_id;
    }

    public void setWork_id(int work_id) {
        this.work_id = work_id;
    }

    public String getWork_name() {
        return work_name;
    }

    public void setWork_name(String work_name) {
        this.work_name = work_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWork_type() {
        return work_type;
    }

    public void setWork_type(String work_type) {
        this.work_type = work_type;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getFlwa() {
        return flwa;
    }

    public void setFlwa(String flwa) {
        this.flwa = flwa;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getCom_id() {
        return com_id;
    }

    public void setCom_id(Integer com_id) {
        this.com_id = com_id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }
}
