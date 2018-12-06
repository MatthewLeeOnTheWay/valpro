package com.security.valpro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaMerchandise {

  private Integer id;
  private String product;
  private String goodno;
  private String goodcol;
  private String mdno;
  private String mdstylecode;
  private String oldgoodno;
  private String routno;
  private String mdsexno;
  private String mdnumno;
  private String brandno;
  private String startsemiyearno;
  private String seasonno;
  private String startocassionno;
  private String startthemeno;
  private String designfy;
  private String rawmatfy;
  private String spesalnatuno;
  private String mdstyleno;
  private String mdformno;
  private String colorno;
  private String brightrno;
  private String reguunitno;
  private String mdclassfyno;
  private String mdfyno;
  private String mainmaterialno;
  private String createdBy;
  private java.sql.Timestamp creationDate;
  private String lastUpdateBy;
  private java.sql.Timestamp lastUpdateDate;
  private String remark;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }


  public String getGoodno() {
    return goodno;
  }

  public void setGoodno(String goodno) {
    this.goodno = goodno;
  }


  public String getGoodcol() {
    return goodcol;
  }

  public void setGoodcol(String goodcol) {
    this.goodcol = goodcol;
  }


  public String getMdno() {
    return mdno;
  }

  public void setMdno(String mdno) {
    this.mdno = mdno;
  }


  public String getMdstylecode() {
    return mdstylecode;
  }

  public void setMdstylecode(String mdstylecode) {
    this.mdstylecode = mdstylecode;
  }


  public String getOldgoodno() {
    return oldgoodno;
  }

  public void setOldgoodno(String oldgoodno) {
    this.oldgoodno = oldgoodno;
  }


  public String getRoutno() {
    return routno;
  }

  public void setRoutno(String routno) {
    this.routno = routno;
  }


  public String getMdsexno() {
    return mdsexno;
  }

  public void setMdsexno(String mdsexno) {
    this.mdsexno = mdsexno;
  }


  public String getMdnumno() {
    return mdnumno;
  }

  public void setMdnumno(String mdnumno) {
    this.mdnumno = mdnumno;
  }


  public String getBrandno() {
    return brandno;
  }

  public void setBrandno(String brandno) {
    this.brandno = brandno;
  }


  public String getStartsemiyearno() {
    return startsemiyearno;
  }

  public void setStartsemiyearno(String startsemiyearno) {
    this.startsemiyearno = startsemiyearno;
  }


  public String getSeasonno() {
    return seasonno;
  }

  public void setSeasonno(String seasonno) {
    this.seasonno = seasonno;
  }


  public String getStartocassionno() {
    return startocassionno;
  }

  public void setStartocassionno(String startocassionno) {
    this.startocassionno = startocassionno;
  }


  public String getStartthemeno() {
    return startthemeno;
  }

  public void setStartthemeno(String startthemeno) {
    this.startthemeno = startthemeno;
  }


  public String getDesignfy() {
    return designfy;
  }

  public void setDesignfy(String designfy) {
    this.designfy = designfy;
  }


  public String getRawmatfy() {
    return rawmatfy;
  }

  public void setRawmatfy(String rawmatfy) {
    this.rawmatfy = rawmatfy;
  }


  public String getSpesalnatuno() {
    return spesalnatuno;
  }

  public void setSpesalnatuno(String spesalnatuno) {
    this.spesalnatuno = spesalnatuno;
  }


  public String getMdstyleno() {
    return mdstyleno;
  }

  public void setMdstyleno(String mdstyleno) {
    this.mdstyleno = mdstyleno;
  }


  public String getMdformno() {
    return mdformno;
  }

  public void setMdformno(String mdformno) {
    this.mdformno = mdformno;
  }


  public String getColorno() {
    return colorno;
  }

  public void setColorno(String colorno) {
    this.colorno = colorno;
  }


  public String getBrightrno() {
    return brightrno;
  }

  public void setBrightrno(String brightrno) {
    this.brightrno = brightrno;
  }


  public String getReguunitno() {
    return reguunitno;
  }

  public void setReguunitno(String reguunitno) {
    this.reguunitno = reguunitno;
  }


  public String getMdclassfyno() {
    return mdclassfyno;
  }

  public void setMdclassfyno(String mdclassfyno) {
    this.mdclassfyno = mdclassfyno;
  }


  public String getMdfyno() {
    return mdfyno;
  }

  public void setMdfyno(String mdfyno) {
    this.mdfyno = mdfyno;
  }


  public String getMainmaterialno() {
    return mainmaterialno;
  }

  public void setMainmaterialno(String mainmaterialno) {
    this.mainmaterialno = mainmaterialno;
  }


  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public java.sql.Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(java.sql.Timestamp creationDate) {
    this.creationDate = creationDate;
  }


  public String getLastUpdateBy() {
    return lastUpdateBy;
  }

  public void setLastUpdateBy(String lastUpdateBy) {
    this.lastUpdateBy = lastUpdateBy;
  }


  public java.sql.Timestamp getLastUpdateDate() {
    return lastUpdateDate;
  }

  public void setLastUpdateDate(java.sql.Timestamp lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
