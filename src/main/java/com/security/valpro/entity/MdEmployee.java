package com.security.valpro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MdEmployee {

  private Integer id;
  private String empNo;
  private String empNam;
  private String applyEmpNo;
  private String oldEmpNo;
  private java.sql.Timestamp birthDay;
  private java.sql.Timestamp empInDat;
  private java.sql.Timestamp empOutDate;
  private String idCardNum;
  private String empSex;
  private String empNatuno;
  private String fireYes;
  private double height;
  private String noEmp;
  private double weight;
  private String blood;
  private String zodiacNo;
  private String constellation;
  private String originPriv;
  private String originCity;
  private String colorBind;
  private double leftVision;
  private double rightVision;
  private String empLeaveId;
  private String fireDealId;
  private String empChangId;
  private String empStatus;
  private String administrator;
  private String createdBy;
  private java.sql.Timestamp creationDate;
  private String lastUpdateBy;
  private java.sql.Timestamp lastUpdateDate;
  private String deletedFlag;
  private String remark;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getEmpNo() {
    return empNo;
  }

  public void setEmpNo(String empNo) {
    this.empNo = empNo;
  }


  public String getEmpNam() {
    return empNam;
  }

  public void setEmpNam(String empNam) {
    this.empNam = empNam;
  }


  public String getApplyEmpNo() {
    return applyEmpNo;
  }

  public void setApplyEmpNo(String applyEmpNo) {
    this.applyEmpNo = applyEmpNo;
  }


  public String getOldEmpNo() {
    return oldEmpNo;
  }

  public void setOldEmpNo(String oldEmpNo) {
    this.oldEmpNo = oldEmpNo;
  }


  public java.sql.Timestamp getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(java.sql.Timestamp birthDay) {
    this.birthDay = birthDay;
  }


  public java.sql.Timestamp getEmpInDat() {
    return empInDat;
  }

  public void setEmpInDat(java.sql.Timestamp empInDat) {
    this.empInDat = empInDat;
  }


  public java.sql.Timestamp getEmpOutDate() {
    return empOutDate;
  }

  public void setEmpOutDate(java.sql.Timestamp empOutDate) {
    this.empOutDate = empOutDate;
  }


  public String getIdCardNum() {
    return idCardNum;
  }

  public void setIdCardNum(String idCardNum) {
    this.idCardNum = idCardNum;
  }


  public String getEmpSex() {
    return empSex;
  }

  public void setEmpSex(String empSex) {
    this.empSex = empSex;
  }


  public String getEmpNatuno() {
    return empNatuno;
  }

  public void setEmpNatuno(String empNatuno) {
    this.empNatuno = empNatuno;
  }


  public String getFireYes() {
    return fireYes;
  }

  public void setFireYes(String fireYes) {
    this.fireYes = fireYes;
  }


  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }


  public String getNoEmp() {
    return noEmp;
  }

  public void setNoEmp(String noEmp) {
    this.noEmp = noEmp;
  }


  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }


  public String getBlood() {
    return blood;
  }

  public void setBlood(String blood) {
    this.blood = blood;
  }


  public String getZodiacNo() {
    return zodiacNo;
  }

  public void setZodiacNo(String zodiacNo) {
    this.zodiacNo = zodiacNo;
  }


  public String getConstellation() {
    return constellation;
  }

  public void setConstellation(String constellation) {
    this.constellation = constellation;
  }


  public String getOriginPriv() {
    return originPriv;
  }

  public void setOriginPriv(String originPriv) {
    this.originPriv = originPriv;
  }


  public String getOriginCity() {
    return originCity;
  }

  public void setOriginCity(String originCity) {
    this.originCity = originCity;
  }


  public String getColorBind() {
    return colorBind;
  }

  public void setColorBind(String colorBind) {
    this.colorBind = colorBind;
  }


  public double getLeftVision() {
    return leftVision;
  }

  public void setLeftVision(double leftVision) {
    this.leftVision = leftVision;
  }


  public double getRightVision() {
    return rightVision;
  }

  public void setRightVision(double rightVision) {
    this.rightVision = rightVision;
  }


  public String getEmpLeaveId() {
    return empLeaveId;
  }

  public void setEmpLeaveId(String empLeaveId) {
    this.empLeaveId = empLeaveId;
  }


  public String getFireDealId() {
    return fireDealId;
  }

  public void setFireDealId(String fireDealId) {
    this.fireDealId = fireDealId;
  }


  public String getEmpChangId() {
    return empChangId;
  }

  public void setEmpChangId(String empChangId) {
    this.empChangId = empChangId;
  }


  public String getEmpStatus() {
    return empStatus;
  }

  public void setEmpStatus(String empStatus) {
    this.empStatus = empStatus;
  }


  public String getAdministrator() {
    return administrator;
  }

  public void setAdministrator(String administrator) {
    this.administrator = administrator;
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


  public String getDeletedFlag() {
    return deletedFlag;
  }

  public void setDeletedFlag(String deletedFlag) {
    this.deletedFlag = deletedFlag;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
