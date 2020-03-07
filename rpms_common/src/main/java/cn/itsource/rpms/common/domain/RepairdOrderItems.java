package cn.itsource.rpms.common.domain;

import cn.itsource.basic.domain.BaseDomain;

import java.math.BigDecimal;

public class RepairdOrderItems extends BaseDomain {
   //配件价格
   private BigDecimal amt1;
   //工时费
   private BigDecimal amt2;
   //配件数量
   private Integer num;
   //总金额
   private BigDecimal totalAmt;
   //维修工单id
   private Long mainId;
   //维修人员id
   private RepairPerson repairPerson;
   //配件id
   private Parts parts;

   public BigDecimal getAmt1() {
      return amt1;
   }

   public void setAmt1(BigDecimal amt1) {
      this.amt1 = amt1;
   }

   public BigDecimal getAmt2() {
      return amt2;
   }

   public void setAmt2(BigDecimal amt2) {
      this.amt2 = amt2;
   }

   public Integer getNum() {
      return num;
   }

   public void setNum(Integer num) {
      this.num = num;
   }

   public BigDecimal getTotalAmt() {
      return totalAmt;
   }

   public void setTotalAmt(BigDecimal totalAmt) {
      this.totalAmt = totalAmt;
   }

   public Long getMainId() {
      return mainId;
   }

   public void setMainId(Long mainId) {
      this.mainId = mainId;
   }

   public RepairPerson getRepairPerson() {
      return repairPerson;
   }

   public void setRepairPerson(RepairPerson repairPerson) {
      this.repairPerson = repairPerson;
   }

   public Parts getParts() {
      return parts;
   }

   public void setParts(Parts parts) {
      this.parts = parts;
   }

   @Override
   public String toString() {
      return "RepairdOrderItems{" +
              "amt1=" + amt1 +
              ", amt2=" + amt2 +
              ", num=" + num +
              ", totalAmt=" + totalAmt +
              ", mainId=" + mainId +
              ", repairPerson=" + repairPerson +
              ", parts=" + parts +
              '}';
   }
}
