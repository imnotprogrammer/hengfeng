package com.hengfeng.web.table;

import java.io.Serializable;
import java.util.Date;

/**
 * job_info
 * @author 
 */
public class JobInfo implements Serializable {
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 创建时间
     */
    private Date created_at;

    /**
     * 创建时间
     */
    private String unit_name;

    /**
     * 薪资级别
     */
    private Integer salary_type;

    /**
     * 0 上线 1 下线
     */
    private Byte status;

    /**
     * 岗位说明
     */
    private String desc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public Integer getSalary_type() {
        return salary_type;
    }

    public void setSalary_type(Integer salary_type) {
        this.salary_type = salary_type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

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
        JobInfo other = (JobInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getCreated_at() == null ? other.getCreated_at() == null : this.getCreated_at().equals(other.getCreated_at()))
            && (this.getUnit_name() == null ? other.getUnit_name() == null : this.getUnit_name().equals(other.getUnit_name()))
            && (this.getSalary_type() == null ? other.getSalary_type() == null : this.getSalary_type().equals(other.getSalary_type()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getCreated_at() == null) ? 0 : getCreated_at().hashCode());
        result = prime * result + ((getUnit_name() == null) ? 0 : getUnit_name().hashCode());
        result = prime * result + ((getSalary_type() == null) ? 0 : getSalary_type().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", created_at=").append(created_at);
        sb.append(", unit_name=").append(unit_name);
        sb.append(", salary_type=").append(salary_type);
        sb.append(", status=").append(status);
        sb.append(", desc=").append(desc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}