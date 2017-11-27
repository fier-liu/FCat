package com.xfdmao.fcat.user.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class TUser {
    @Id
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String birthday;

    private String address;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "tel_phone")
    private String telPhone;

    private String email;

    /**
     * 'F'-Ů��'M'-�У�'S'-����
     */
    private String sex;

    /**
     * 'Y'-���'N'-δ���'D'-��ɾ��
     */
    private String status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return mobile_phone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * @param mobilePhone
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * @return tel_phone
     */
    public String getTelPhone() {
        return telPhone;
    }

    /**
     * @param telPhone
     */
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * ��ȡ'F'-Ů��'M'-�У�'S'-����
     *
     * @return sex - 'F'-Ů��'M'-�У�'S'-����
     */
    public String getSex() {
        return sex;
    }

    /**
     * ����'F'-Ů��'M'-�У�'S'-����
     *
     * @param sex 'F'-Ů��'M'-�У�'S'-����
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * ��ȡ'Y'-���'N'-δ���'D'-��ɾ��
     *
     * @return status - 'Y'-���'N'-δ���'D'-��ɾ��
     */
    public String getStatus() {
        return status;
    }

    /**
     * ����'Y'-���'N'-δ���'D'-��ɾ��
     *
     * @param status 'Y'-���'N'-δ���'D'-��ɾ��
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}