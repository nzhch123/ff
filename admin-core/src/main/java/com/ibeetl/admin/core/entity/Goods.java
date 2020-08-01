package com.ibeetl.admin.core.entity;


import com.ibeetl.admin.core.entity.BaseEntity;

public class Goods extends BaseEntity {

  private long id;
  private long goodsId;
  private String statDate;
  private String goodsName;
  private String goodsFavCnt;
  private String goodsUv;
  private String goodsPv;
  private String payOrdrCnt;
  private String goodsVcr;
  private String pctGoodsVcr;
  private String payOrdrGoodsQty;
  private String payOrdrUsrCnt;
  private String payOrdrAmt;
  private String cfmOrdrCnt;
  private String cfmOrdrGoodsQty;
  private String isNewstyle;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }


  public String getStatDate() {
    return statDate;
  }

  public void setStatDate(String statDate) {
    this.statDate = statDate;
  }


  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }


  public String getGoodsFavCnt() {
    return goodsFavCnt;
  }

  public void setGoodsFavCnt(String goodsFavCnt) {
    this.goodsFavCnt = goodsFavCnt;
  }


  public String getGoodsUv() {
    return goodsUv;
  }

  public void setGoodsUv(String goodsUv) {
    this.goodsUv = goodsUv;
  }


  public String getGoodsPv() {
    return goodsPv;
  }

  public void setGoodsPv(String goodsPv) {
    this.goodsPv = goodsPv;
  }


  public String getPayOrdrCnt() {
    return payOrdrCnt;
  }

  public void setPayOrdrCnt(String payOrdrCnt) {
    this.payOrdrCnt = payOrdrCnt;
  }


  public String getGoodsVcr() {
    return goodsVcr;
  }

  public void setGoodsVcr(String goodsVcr) {
    this.goodsVcr = goodsVcr;
  }


  public String getPctGoodsVcr() {
    return pctGoodsVcr;
  }

  public void setPctGoodsVcr(String pctGoodsVcr) {
    this.pctGoodsVcr = pctGoodsVcr;
  }


  public String getPayOrdrGoodsQty() {
    return payOrdrGoodsQty;
  }

  public void setPayOrdrGoodsQty(String payOrdrGoodsQty) {
    this.payOrdrGoodsQty = payOrdrGoodsQty;
  }


  public String getPayOrdrUsrCnt() {
    return payOrdrUsrCnt;
  }

  public void setPayOrdrUsrCnt(String payOrdrUsrCnt) {
    this.payOrdrUsrCnt = payOrdrUsrCnt;
  }


  public String getPayOrdrAmt() {
    return payOrdrAmt;
  }

  public void setPayOrdrAmt(String payOrdrAmt) {
    this.payOrdrAmt = payOrdrAmt;
  }


  public String getCfmOrdrCnt() {
    return cfmOrdrCnt;
  }

  public void setCfmOrdrCnt(String cfmOrdrCnt) {
    this.cfmOrdrCnt = cfmOrdrCnt;
  }


  public String getCfmOrdrGoodsQty() {
    return cfmOrdrGoodsQty;
  }

  public void setCfmOrdrGoodsQty(String cfmOrdrGoodsQty) {
    this.cfmOrdrGoodsQty = cfmOrdrGoodsQty;
  }


  public String getIsNewstyle() {
    return isNewstyle;
  }

  public void setIsNewstyle(String isNewstyle) {
    this.isNewstyle = isNewstyle;
  }

}
