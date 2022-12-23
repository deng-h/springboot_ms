package com.dh.ms.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 踏板固定参数表
 * @TableName pedal_fixed_param
 */
@TableName(value ="pedal_fixed_param")
@Data
public class PedalFixedParam implements Serializable {
    /**
     *  ID索引也是唯一任务编号
     */
    @TableId(value = "id")
    private String id;

    /**
     * 踏板设备的蓝牙MAC地址
     */
    @TableField(value = "bluetooth_mac_address")
    private String bluetoothMacAddress;

    /**
     * 踏板型号
     */
    @TableField(value = "pedal_model")
    private String pedalModel;

    /**
     * 堵转电流输出
     */
    @TableField(value = "output_block_current")
    private String outputBlockCurrent;

    /**
     * 堵转电流输入
     */
    @TableField(value = "input_block_current")
    private String inputBlockCurrent;

    /**
     * 保护时间
     */
    @TableField(value = "guard_time")
    private String guardTime;

    /**
     * 低电压点下限
     */
    @TableField(value = "low_voltage_lower_limit")
    private String lowVoltageLowerLimit;

    /**
     * 低电压点上限
     */
    @TableField(value = "low_voltage_upper_limit")
    private String lowVoltageUpperLimit;

    /**
     * 汽车启动电压下限
     */
    @TableField(value = "start_voltage_lower_limit")
    private String startVoltageLowerLimit;

    /**
     * 汽车启动电压上限
     */
    @TableField(value = "start_voltage_upper_limit")
    private String startVoltageUpperLimit;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create")
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified")
    private Date gmtModified;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PedalFixedParam other = (PedalFixedParam) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBluetoothMacAddress() == null ? other.getBluetoothMacAddress() == null : this.getBluetoothMacAddress().equals(other.getBluetoothMacAddress()))
            && (this.getPedalModel() == null ? other.getPedalModel() == null : this.getPedalModel().equals(other.getPedalModel()))
            && (this.getOutputBlockCurrent() == null ? other.getOutputBlockCurrent() == null : this.getOutputBlockCurrent().equals(other.getOutputBlockCurrent()))
            && (this.getInputBlockCurrent() == null ? other.getInputBlockCurrent() == null : this.getInputBlockCurrent().equals(other.getInputBlockCurrent()))
            && (this.getGuardTime() == null ? other.getGuardTime() == null : this.getGuardTime().equals(other.getGuardTime()))
            && (this.getLowVoltageLowerLimit() == null ? other.getLowVoltageLowerLimit() == null : this.getLowVoltageLowerLimit().equals(other.getLowVoltageLowerLimit()))
            && (this.getLowVoltageUpperLimit() == null ? other.getLowVoltageUpperLimit() == null : this.getLowVoltageUpperLimit().equals(other.getLowVoltageUpperLimit()))
            && (this.getStartVoltageLowerLimit() == null ? other.getStartVoltageLowerLimit() == null : this.getStartVoltageLowerLimit().equals(other.getStartVoltageLowerLimit()))
            && (this.getStartVoltageUpperLimit() == null ? other.getStartVoltageUpperLimit() == null : this.getStartVoltageUpperLimit().equals(other.getStartVoltageUpperLimit()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getGmtCreate() == null ? other.getGmtCreate() == null : this.getGmtCreate().equals(other.getGmtCreate()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBluetoothMacAddress() == null) ? 0 : getBluetoothMacAddress().hashCode());
        result = prime * result + ((getPedalModel() == null) ? 0 : getPedalModel().hashCode());
        result = prime * result + ((getOutputBlockCurrent() == null) ? 0 : getOutputBlockCurrent().hashCode());
        result = prime * result + ((getInputBlockCurrent() == null) ? 0 : getInputBlockCurrent().hashCode());
        result = prime * result + ((getGuardTime() == null) ? 0 : getGuardTime().hashCode());
        result = prime * result + ((getLowVoltageLowerLimit() == null) ? 0 : getLowVoltageLowerLimit().hashCode());
        result = prime * result + ((getLowVoltageUpperLimit() == null) ? 0 : getLowVoltageUpperLimit().hashCode());
        result = prime * result + ((getStartVoltageLowerLimit() == null) ? 0 : getStartVoltageLowerLimit().hashCode());
        result = prime * result + ((getStartVoltageUpperLimit() == null) ? 0 : getStartVoltageUpperLimit().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getGmtCreate() == null) ? 0 : getGmtCreate().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bluetoothMacAddress=").append(bluetoothMacAddress);
        sb.append(", pedalModel=").append(pedalModel);
        sb.append(", outputBlockCurrent=").append(outputBlockCurrent);
        sb.append(", inputBlockCurrent=").append(inputBlockCurrent);
        sb.append(", guardTime=").append(guardTime);
        sb.append(", lowVoltageLowerLimit=").append(lowVoltageLowerLimit);
        sb.append(", lowVoltageUpperLimit=").append(lowVoltageUpperLimit);
        sb.append(", startVoltageLowerLimit=").append(startVoltageLowerLimit);
        sb.append(", startVoltageUpperLimit=").append(startVoltageUpperLimit);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}