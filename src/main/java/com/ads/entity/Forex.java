package com.ads.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017/12/15
 */
@Entity
public class Forex {
    private String id;
    private String symbolId;
    private String symbolCode;
    private String symbolName;
    private String enabled;
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
    @Column(name = "symbolId")
    public String getSymbolId() {
        return symbolId;
    }
    
    public void setSymbolId(String symbolId) {
        this.symbolId = symbolId;
    }
    
    @Basic
    @Column(name = "symbolCode")
    public String getSymbolCode() {
        return symbolCode;
    }
    
    public void setSymbolCode(String symbolCode) {
        this.symbolCode = symbolCode;
    }
    
    @Basic
    @Column(name = "symbolName")
    public String getSymbolName() {
        return symbolName;
    }
    
    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }
    
    @Basic
    @Column(name = "enabled")
    public String getEnabled() {
        return enabled;
    }
    
    public void setEnabled(String enabled) {
        this.enabled = enabled;
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
        return Objects.equals(id, forex.id) &&
                Objects.equals(symbolId, forex.symbolId) &&
                Objects.equals(symbolCode, forex.symbolCode) &&
                Objects.equals(symbolName, forex.symbolName) &&
                Objects.equals(enabled, forex.enabled) &&
                Objects.equals(createdTime, forex.createdTime) &&
                Objects.equals(updatedTime, forex.updatedTime);
    }
    
    @Override
    public int hashCode() {
        
        return Objects.hash(id, symbolId, symbolCode, symbolName, enabled, createdTime, updatedTime);
    }
}
