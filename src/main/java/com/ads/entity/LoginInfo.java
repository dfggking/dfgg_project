package com.ads.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/14
 */
@Entity
@Table(name = "login_info", schema = "adsdb", catalog = "")
public class LoginInfo {
    private String id;
    private String userId;
    private String mobile;
    private String password;
    private String status;
    private String type;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp lastLoginTime;
    private Byte errorLoginCount;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "last_login_time")
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Basic
    @Column(name = "error_login_count")
    public Byte getErrorLoginCount() {
        return errorLoginCount;
    }

    public void setErrorLoginCount(Byte errorLoginCount) {
        this.errorLoginCount = errorLoginCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginInfo loginInfo = (LoginInfo) o;
        return Objects.equals(id, loginInfo.id) &&
                Objects.equals(userId, loginInfo.userId) &&
                Objects.equals(mobile, loginInfo.mobile) &&
                Objects.equals(password, loginInfo.password) &&
                Objects.equals(status, loginInfo.status) &&
                Objects.equals(type, loginInfo.type) &&
                Objects.equals(createTime, loginInfo.createTime) &&
                Objects.equals(updateTime, loginInfo.updateTime) &&
                Objects.equals(lastLoginTime, loginInfo.lastLoginTime) &&
                Objects.equals(errorLoginCount, loginInfo.errorLoginCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, mobile, password, status, type, createTime, updateTime, lastLoginTime, errorLoginCount);
    }
}
