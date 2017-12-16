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
 * @date 2017/12/16
 */
@Entity
public class Order {
    private String id;
    private String userId;
    private String forexId;
    private BigDecimal buyPrice;
    private BigDecimal strikePrice;
    private BigDecimal money;
    private String trade;
    private short cycle;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp strikeTime;
    
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
    @Column(name = "forex_id")
    public String getForexId() {
        return forexId;
    }
    
    public void setForexId(String forexId) {
        this.forexId = forexId;
    }
    
    @Basic
    @Column(name = "buy_price")
    public BigDecimal getBuyPrice() {
        return buyPrice;
    }
    
    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }
    
    @Basic
    @Column(name = "strike_price")
    public BigDecimal getStrikePrice() {
        return strikePrice;
    }
    
    public void setStrikePrice(BigDecimal strikePrice) {
        this.strikePrice = strikePrice;
    }
    
    @Basic
    @Column(name = "money")
    public BigDecimal getMoney() {
        return money;
    }
    
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    
    @Basic
    @Column(name = "trade")
    public String getTrade() {
        return trade;
    }
    
    public void setTrade(String trade) {
        this.trade = trade;
    }
    
    @Basic
    @Column(name = "cycle")
    public short getCycle() {
        return cycle;
    }
    
    public void setCycle(short cycle) {
        this.cycle = cycle;
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
    @Column(name = "strike_time")
    public Timestamp getStrikeTime() {
        return strikeTime;
    }
    
    public void setStrikeTime(Timestamp strikeTime) {
        this.strikeTime = strikeTime;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return cycle == order.cycle &&
                Objects.equals(id, order.id) &&
                Objects.equals(userId, order.userId) &&
                Objects.equals(forexId, order.forexId) &&
                Objects.equals(buyPrice, order.buyPrice) &&
                Objects.equals(strikePrice, order.strikePrice) &&
                Objects.equals(money, order.money) &&
                Objects.equals(trade, order.trade) &&
                Objects.equals(createTime, order.createTime) &&
                Objects.equals(updateTime, order.updateTime) &&
                Objects.equals(strikeTime, order.strikeTime);
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(id, userId, forexId, buyPrice, strikePrice, money, trade, cycle, createTime, updateTime, strikeTime);
    }
}
