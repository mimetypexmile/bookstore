package com.xzl.bookstore.pojo.po;

import java.util.Date;

public class Orders {
    private Long orderId;

    private Long uid;

    private Date created;

    private Byte status;

    private String recevierName;

    private String addrId;

    private String recevierTel;

    private String content;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRecevierName() {
        return recevierName;
    }

    public void setRecevierName(String recevierName) {
        this.recevierName = recevierName == null ? null : recevierName.trim();
    }

    public String getAddrId() {
        return addrId;
    }

    public void setAddrId(String addrId) {
        this.addrId = addrId == null ? null : addrId.trim();
    }

    public String getRecevierTel() {
        return recevierTel;
    }

    public void setRecevierTel(String recevierTel) {
        this.recevierTel = recevierTel == null ? null : recevierTel.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}