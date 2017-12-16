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
public class Price {
    private String id;
    private String symbolId;
    private String symbolCode;
    private String symbolName;
    private BigDecimal buyPrice;
    private BigDecimal sellPrice;
    private BigDecimal pltd;
    private BigDecimal ratio;
    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal high;
    private BigDecimal low;
    private Timestamp createdTime;
    private String fromAddress;
    private String fromName;
    
    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "symbol_id")
    public String getSymbolId() {
        return symbolId;
    }
    
    public void setSymbolId(String symbolId) {
        this.symbolId = symbolId;
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
    @Column(name = "symbol_name")
    public String getSymbolName() {
        return symbolName;
    }
    
    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
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
    @Column(name = "sell_price")
    public BigDecimal getSellPrice() {
        return sellPrice;
    }
    
    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }
    
    @Basic
    @Column(name = "pltd")
    public BigDecimal getPltd() {
        return pltd;
    }
    
    public void setPltd(BigDecimal pltd) {
        this.pltd = pltd;
    }
    
    @Basic
    @Column(name = "ratio")
    public BigDecimal getRatio() {
        return ratio;
    }
    
    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
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
    @Column(name = "close")
    public BigDecimal getClose() {
        return close;
    }
    
    public void setClose(BigDecimal close) {
        this.close = close;
    }
    
    @Basic
    @Column(name = "high")
    public BigDecimal getHigh() {
        return high;
    }
    
    public void setHigh(BigDecimal high) {
        this.high = high;
    }
    
    @Basic
    @Column(name = "low")
    public BigDecimal getLow() {
        return low;
    }
    
    public void setLow(BigDecimal low) {
        this.low = low;
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
    @Column(name = "from_address")
    public String getFromAddress() {
        return fromAddress;
    }
    
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }
    
    @Basic
    @Column(name = "from_name")
    public String getFromName() {
        return fromName;
    }
    
    public void setFromName(String fromName) {
        this.fromName = fromName;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(id, price.id) &&
                Objects.equals(symbolId, price.symbolId) &&
                Objects.equals(symbolCode, price.symbolCode) &&
                Objects.equals(symbolName, price.symbolName) &&
                Objects.equals(buyPrice, price.buyPrice) &&
                Objects.equals(sellPrice, price.sellPrice) &&
                Objects.equals(pltd, price.pltd) &&
                Objects.equals(ratio, price.ratio) &&
                Objects.equals(open, price.open) &&
                Objects.equals(close, price.close) &&
                Objects.equals(high, price.high) &&
                Objects.equals(low, price.low) &&
                Objects.equals(createdTime, price.createdTime) &&
                Objects.equals(fromAddress, price.fromAddress) &&
                Objects.equals(fromName, price.fromName);
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(id, symbolId, symbolCode, symbolName, buyPrice, sellPrice, pltd, ratio, open, close, high, low, createdTime, fromAddress, fromName);
    }
}
