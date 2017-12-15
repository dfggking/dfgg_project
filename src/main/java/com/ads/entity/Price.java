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
 * @date 2017/12/14
 */
@Entity
public class Price {
    private String id;
    private String symbolCode;
    private BigDecimal lastTrade;
    private String chg;
    private BigDecimal open;
    private BigDecimal highest;
    private BigDecimal lowest;
    private String amplitude;
    private BigDecimal prevClose;
    private BigDecimal bid;
    private BigDecimal ask;
    private Timestamp createdTime;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "symbol_code")
    public String getSymbolCode() {
        return symbolCode;
    }

    public void setSymbolCode(String symbolCode) {
        this.symbolCode = symbolCode;
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
    @Column(name = "created_time")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(id, price.id) &&
                Objects.equals(symbolCode, price.symbolCode) &&
                Objects.equals(lastTrade, price.lastTrade) &&
                Objects.equals(chg, price.chg) &&
                Objects.equals(open, price.open) &&
                Objects.equals(highest, price.highest) &&
                Objects.equals(lowest, price.lowest) &&
                Objects.equals(amplitude, price.amplitude) &&
                Objects.equals(prevClose, price.prevClose) &&
                Objects.equals(bid, price.bid) &&
                Objects.equals(ask, price.ask) &&
                Objects.equals(createdTime, price.createdTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, symbolCode, lastTrade, chg, open, highest, lowest, amplitude, prevClose, bid, ask, createdTime);
    }
}
