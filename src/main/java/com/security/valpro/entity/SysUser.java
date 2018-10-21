package com.security.valpro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SysUser {
    private Integer id;
    private String password;
    private String username;
    private String mobile;
    private String salt;
    private String email;
    private String address;
    private java.sql.Timestamp birthday;
    private java.sql.Timestamp creationDate;
    private String createdBy;
    private String lastUpdateBy;
    private java.sql.Timestamp lastUpdateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
    return id;
  }

    public void setId(Integer id) {
    this.id = id;
  }


    public String getPassword() {
    return password;
  }

    public void setPassword(String password) {
    this.password = password;
  }


    public String getUsername() {
    return username;
  }

    public void setUsername(String username) {
    this.username = username;
  }


    public String getMobile() {
    return mobile;
  }

    public void setMobile(String mobile) {
    this.mobile = mobile;
  }


    public String getSalt() {
    return salt;
  }

    public void setSalt(String salt) {
    this.salt = salt;
  }


    public String getEmail() {
    return email;
  }

    public void setEmail(String email) {
    this.email = email;
  }


    public String getAddress() {
    return address;
  }

    public void setAddress(String address) {
    this.address = address;
  }


    public java.sql.Timestamp getBirthday() {
    return birthday;
  }

    public void setBirthday(java.sql.Timestamp birthday) {
    this.birthday = birthday;
  }


    public java.sql.Timestamp getCreationDate() {
    return creationDate;
  }

    public void setCreationDate(java.sql.Timestamp creationDate) {
    this.creationDate = creationDate;
  }


    public String getCreatedBy() {
    return createdBy;
  }

    public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
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

}
