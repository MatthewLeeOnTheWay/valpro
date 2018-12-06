package com.security.valpro.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * md_stock:库存表
 */
@Entity
@Table(name = "md_stock")
public class MdStock implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * ID:
   */

  private Integer id;

  /**
   * 库存点代号（MA_MDPOINT:MDPOTNO）:库存点代号（MA_MDPOINT:MDPOTNO）
   */

  private String mdpotno;

  /**
   * 储位（MA_MDSTORAGE:STORAGENO）:储位（MA_MDSTORAGE:STORAGENO）
   */

  private String storageno;

  /**
   * 货色号（MA_MERCHANDISE:PRODUCT）:货色号（MA_MERCHANDISE:PRODUCT）
   */
  private String product;

  /**
   * 尺寸:尺寸
   */
  private String mdsize;

  /**
   * 库存量:库存量
   */
  private Integer stkqty;

  /**
   * 在途量:在途量
   */
  private Integer onwayqty;

  /**
   * 预移入量:预移入量
   */

  private Integer ptrinqty;

  /**
   * 预移出量:预移出量
   */
  private Integer ptroutqty;

  /**
   * 预批出量:预批出量
   */
  private Integer pwhsoutqty;

  /**
   * 创建人:创建人
   */
  private String createdBy;

  /**
   * 创建时间:创建时间
   */
  private Date creationDate;

  /**
   * 最后修改人:最后修改人
   */
  private String lastUpdateBy;

  /**
   * 最后修改时间:最后修改时间
   */
  private Date lastUpdateDate;

  /**
   * 备注:备注
   */
  private String remark;


  public void setId(Integer id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", nullable = false)
  public Integer getId() {
    return id;
  }

  public void setMdpotno(String mdpotno) {
    this.mdpotno = mdpotno;
  }

  @Column(name = "MDPOTNO")
  public String getMdpotno() {
    return mdpotno;
  }

  public void setStorageno(String storageno) {
    this.storageno = storageno;
  }

  @Column(name = "STORAGENO")
  public String getStorageno() {
    return storageno;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  @Column(name = "PRODUCT")
  public String getProduct() {
    return product;
  }

  public void setMdsize(String mdsize) {
    this.mdsize = mdsize;
  }

  @Column(name = "MDSIZE")
  public String getMdsize() {
    return mdsize;
  }

  public void setStkqty(Integer stkqty) {
    this.stkqty = stkqty;
  }

  @Column(name = "STKQTY")
  public Integer getStkqty() {
    return stkqty;
  }

  public void setOnwayqty(Integer onwayqty) {
    this.onwayqty = onwayqty;
  }

  @Column(name = "ONWAYQTY")
  public Integer getOnwayqty() {
    return onwayqty;
  }

  public void setPtrinqty(Integer ptrinqty) {
    this.ptrinqty = ptrinqty;
  }

  @Column(name = "PTRINQTY")
  public Integer getPtrinqty() {
    return ptrinqty;
  }

  public void setPtroutqty(Integer ptroutqty) {
    this.ptroutqty = ptroutqty;
  }

  @Column(name = "PTROUTQTY")
  public Integer getPtroutqty() {
    return ptroutqty;
  }

  public void setPwhsoutqty(Integer pwhsoutqty) {
    this.pwhsoutqty = pwhsoutqty;
  }

  @Column(name = "PWHSOUTQTY")
  public Integer getPwhsoutqty() {
    return pwhsoutqty;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  @Column(name = "CREATED_BY")
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "CREATION_DATE")
  public Date getCreationDate() {
    return creationDate;
  }

  public void setLastUpdateBy(String lastUpdateBy) {
    this.lastUpdateBy = lastUpdateBy;
  }

  @Column(name = "LAST_UPDATE_BY")
  public String getLastUpdateBy() {
    return lastUpdateBy;
  }

  public void setLastUpdateDate(Date lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "LAST_UPDATE_DATE")
  public Date getLastUpdateDate() {
    return lastUpdateDate;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Column(name = "REMARK")
  public String getRemark() {
    return remark;
  }
}