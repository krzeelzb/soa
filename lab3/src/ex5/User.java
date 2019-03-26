package ex5;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@SessionScoped
@ManagedBean(name = "user")
public class User {

    private String name;
    private String email;
    private Integer age;
    private String gender;
    private String education;
    private Integer height;
    //for women
    private String breast;
    private String bra;
    private String waistline;
    private String hips;

    //for men
    private String chest;
    private String midsection ;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEducation() {
        return education;
    }

    public Integer getHeight() {
        return height;
    }

    public String getBreast() {
        return breast;
    }

    public String getBra() {
        return bra;
    }

    public String getWaistline() {
        return waistline;
    }

    public String getHips() {
        return hips;
    }

    public String getChest() {
        return chest;
    }

    public String getMidsection() {
        return midsection;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setBreast(String breast) {
        this.breast = breast;
    }

    public void setBra(String bra) {
        this.bra = bra;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline;
    }

    public void setHips(String hips) {
        this.hips = hips;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public void setMidsection(String midsection) {
        this.midsection = midsection;
    }




}
