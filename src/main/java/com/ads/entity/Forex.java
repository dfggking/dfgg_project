package com.ads.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Created by jinyf on 2017/12/6.
 */
@Entity
public class Forex {
    private String id;
    private String symbol;
    private String name;
    private BigDecimal lastTrade;
    private String chg;
    private String change;
    private BigDecimal open;
    private BigDecimal highest;
    private BigDecimal lowest;
    private String amplitude;
    private BigDecimal prevClose;
    private BigDecimal bid;
    private BigDecimal ask;
    private byte enabled;
    private BigDecimal profite;
    private Timestamp createdTime;
    private Timestamp updatedTime;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "symbol")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "last_trade")
    public BigDecimal getLastTrade() {
        return lastTrade;
    }

    public void setLastTrade(BigDecimal lastTrade) {
        this.lastTrade = lastTrade;
    }

    @Basic
    @Column(name = "chg")
    public String getChg() {
        return chg;
    }

    public void setChg(String chg) {
        this.chg = chg;
    }

    @Basic
    @Column(name = "change")
    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    @Basic
    @Column(name = "open")
    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    @Basic
    @Column(name = "highest")
    public BigDecimal getHighest() {
        return highest;
    }

    public void setHighest(BigDecimal highest) {
        this.highest = highest;
    }

    @Basic
    @Column(name = "lowest")
    public BigDecimal getLowest() {
        return lowest;
    }

    public void setLowest(BigDecimal lowest) {
        this.lowest = lowest;
    }

    @Basic
    @Column(name = "amplitude")
    public String getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(String amplitude) {
        this.amplitude = amplitude;
    }

    @Basic
    @Column(name = "prev_close")
    public BigDecimal getPrevClose() {
        return prevClose;
    }

    public void setPrevClose(BigDecimal prevClose) {
        this.prevClose = prevClose;
    }

    @Basic
    @Column(name = "bid")
    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    @Basic
    @Column(name = "ask")
    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    @Basic
    @Column(name = "enabled")
    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "profite")
    public BigDecimal getProfite() {
        return profite;
    }

    public void setProfite(BigDecimal profite) {
        this.profite = profite;
    }

    @Basic
    @Column(name = "created_time")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "updated_time")
    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forex forex = (Forex) o;
        return enabled == forex.enabled &&
                Objects.equals(id, forex.id) &&
                Objects.equals(symbol, forex.symbol) &&
                Objects.equals(name, forex.name) &&
                Objects.equals(lastTrade, forex.lastTrade) &&
                Objects.equals(chg, forex.chg) &&
                Objects.equals(change, forex.change) &&
                Objects.equals(open, forex.open) &&
                Objects.equals(highest, forex.highest) &&
                Objects.equals(lowest, forex.lowest) &&
                Objects.equals(amplitude, forex.amplitude) &&
                Objects.equals(prevClose, forex.prevClose) &&
                Objects.equals(bid, forex.bid) &&
                Objects.equals(ask, forex.ask) &&
                Objects.equals(profite, forex.profite) &&
                Objects.equals(createdTime, forex.createdTime) &&
                Objects.equals(updatedTime, forex.updatedTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, symbol, name, lastTrade, chg, change, open, highest, lowest, amplitude, prevClose, bid, ask, enabled, profite, createdTime, updatedTime);
    }
}
