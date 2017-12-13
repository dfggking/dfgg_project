package com.ads.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by jinyf on 2017/12/6.
 */
@Entity
@Table(name = "role_info", schema = "adsdb", catalog = "")
public class RoleInfo {
    private String id;
    private String roleName;
    private String userId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleInfo roleInfo = (RoleInfo) o;
        return Objects.equals(id, roleInfo.id) &&
                Objects.equals(roleName, roleInfo.roleName) &&
                Objects.equals(userId, roleInfo.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, roleName, userId);
    }
}
