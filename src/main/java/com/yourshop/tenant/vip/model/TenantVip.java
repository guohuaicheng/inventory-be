package com.yourshop.tenant.vip.model;

import com.yourshop.core.model.TenantBaseModel;

/**
 * @author G
 */
public class TenantVip extends TenantBaseModel {
    private String id;
    private String vipNo;
    private String name;
    private String phone;
    private double remainMoney;
    private double chargeTotalMoney;
    private int chargeCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVipNo() {
        return vipNo;
    }

    public void setVipNo(String vipNo) {
        this.vipNo = vipNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(double remainMoney) {
        this.remainMoney = remainMoney;
    }

    public double getChargeTotalMoney() {
        return chargeTotalMoney;
    }

    public void setChargeTotalMoney(double chargeTotalMoney) {
        this.chargeTotalMoney = chargeTotalMoney;
    }

    public int getChargeCount() {
        return chargeCount;
    }

    public void setChargeCount(int chargeCount) {
        this.chargeCount = chargeCount;
    }
}
