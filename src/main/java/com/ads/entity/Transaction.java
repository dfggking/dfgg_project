package com.ads.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/15
 */
@Entity
public class Transaction {
    private String id;
    private String userId;
    private String remark;
    private Timestamp createTime;
    private BigDecimal sum;
    private String mode;
    
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
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
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
    @Column(name = "sum")
    public BigDecimal getSum() {
        return sum;
    }
    
    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
    
    @Basic
    @Column(name = "mode")
    public String getMode() {
        return mode;
    }
    
    public void setMode(String mode) {
        this.mode = mode;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(sum, that.sum) &&
                Objects.equals(mode, that.mode);
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(id, userId, remark, createTime, sum, mode);
    }
}
