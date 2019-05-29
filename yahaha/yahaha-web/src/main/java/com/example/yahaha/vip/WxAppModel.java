package com.example.yahaha.vip;

/**
 * COM-SYSTEM
 *
 * @author create by yangb in 2019/5/28
 */
public class WxAppModel {

    private String avatarUrl; //用户头像
    private String city; //所在城市
    private String code; //code
    private Integer gender; //性别
    private String nickName; //昵称
    private String country; //国家
    private String province; //省

    @Override
    public String toString() {
        return "WxAppModel{" +
                "avatarUrl='" + avatarUrl + '\'' +
                ", city='" + city + '\'' +
                ", code='" + code + '\'' +
                ", gender=" + gender +
                ", nickName='" + nickName + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
