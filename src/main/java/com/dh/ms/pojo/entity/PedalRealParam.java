package com.dh.ms.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 踏板实时参数表
 * @TableName pedal_real_param
 */
@TableName(value ="pedal_real_param")
@Data
public class PedalRealParam implements Serializable {
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
     * 踏板开关状态
     */
    @TableField(value = "pedal_switch_status")
    private String pedalSwitchStatus;

    /**
     * 实时电压值
     */
    @TableField(value = "realtime_voltage")
    private String realtimeVoltage;

    /**
     * 左门状态
     */
    @TableField(value = "left_door_status")
    private String leftDoorStatus;

    /**
     * 左踏板状态
     */
    @TableField(value = "left_pedal_status")
    private String leftPedalStatus;

    /**
     * 右门状态
     */
    @TableField(value = "right_door_status")
    private String rightDoorStatus;

    /**
     * 右踏板状态
     */
    @TableField(value = "right_pedal_status")
    private String rightPedalStatus;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableField(value = "is_deleted")
    @TableLogic
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
        PedalRealParam other = (PedalRealParam) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBluetoothMacAddress() == null ? other.getBluetoothMacAddress() == null : this.getBluetoothMacAddress().equals(other.getBluetoothMacAddress()))
            && (this.getPedalModel() == null ? other.getPedalModel() == null : this.getPedalModel().equals(other.getPedalModel()))
            && (this.getPedalSwitchStatus() == null ? other.getPedalSwitchStatus() == null : this.getPedalSwitchStatus().equals(other.getPedalSwitchStatus()))
            && (this.getRealtimeVoltage() == null ? other.getRealtimeVoltage() == null : this.getRealtimeVoltage().equals(other.getRealtimeVoltage()))
            && (this.getLeftDoorStatus() == null ? other.getLeftDoorStatus() == null : this.getLeftDoorStatus().equals(other.getLeftDoorStatus()))
            && (this.getLeftPedalStatus() == null ? other.getLeftPedalStatus() == null : this.getLeftPedalStatus().equals(other.getLeftPedalStatus()))
            && (this.getRightDoorStatus() == null ? other.getRightDoorStatus() == null : this.getRightDoorStatus().equals(other.getRightDoorStatus()))
            && (this.getRightPedalStatus() == null ? other.getRightPedalStatus() == null : this.getRightPedalStatus().equals(other.getRightPedalStatus()))
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
        result = prime * result + ((getPedalSwitchStatus() == null) ? 0 : getPedalSwitchStatus().hashCode());
        result = prime * result + ((getRealtimeVoltage() == null) ? 0 : getRealtimeVoltage().hashCode());
        result = prime * result + ((getLeftDoorStatus() == null) ? 0 : getLeftDoorStatus().hashCode());
        result = prime * result + ((getLeftPedalStatus() == null) ? 0 : getLeftPedalStatus().hashCode());
        result = prime * result + ((getRightDoorStatus() == null) ? 0 : getRightDoorStatus().hashCode());
        result = prime * result + ((getRightPedalStatus() == null) ? 0 : getRightPedalStatus().hashCode());
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
        sb.append(", pedalSwitchStatus=").append(pedalSwitchStatus);
        sb.append(", realtimeVoltage=").append(realtimeVoltage);
        sb.append(", leftDoorStatus=").append(leftDoorStatus);
        sb.append(", leftPedalStatus=").append(leftPedalStatus);
        sb.append(", rightDoorStatus=").append(rightDoorStatus);
        sb.append(", rightPedalStatus=").append(rightPedalStatus);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}