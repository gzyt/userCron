package com.example.demo.dao;

public class Weather {
    private String city;        //城市
    private String dateTime;   //时间
    private String tmp_max;       //最高温度
    private String tmp_min;       //最低温度
    private String cond_txt;  //天气实况
    private String wind_dir;  //风向
    private String wind_sc;   //风力
    private String hum;       //相对湿度
    private String pres;      //大气压强
    private String sunStartTime;    //日出时间
    private String sunEndTime;      //日落时间

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTmp_max() {
        return tmp_max;
    }

    public void setTmp_max(String tmp_max) {
        this.tmp_max = tmp_max;
    }

    public String getTmp_min() {
        return tmp_min;
    }

    public void setTmp_min(String tmp_min) {
        this.tmp_min = tmp_min;
    }

    public String getCond_txt() {
        return cond_txt;
    }

    public void setCond_txt(String cond_txt) {
        this.cond_txt = cond_txt;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getWind_sc() {
        return wind_sc;
    }

    public void setWind_sc(String wind_sc) {
        this.wind_sc = wind_sc;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getSunStartTime() {
        return sunStartTime;
    }

    public void setSunStartTime(String sunStartTime) {
        this.sunStartTime = sunStartTime;
    }

    public String getSunEndTime() {
        return sunEndTime;
    }

    public void setSunEndTime(String sunEndTime) {
        this.sunEndTime = sunEndTime;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", tmp_max='" + tmp_max + '\'' +
                ", tmp_min='" + tmp_min + '\'' +
                ", cond_txt='" + cond_txt + '\'' +
                ", wind_dir='" + wind_dir + '\'' +
                ", wind_sc='" + wind_sc + '\'' +
                ", hum='" + hum + '\'' +
                ", pres='" + pres + '\'' +
                ", sunStartTime='" + sunStartTime + '\'' +
                ", sunEndTime='" + sunEndTime + '\'' +
                '}';
    }
}