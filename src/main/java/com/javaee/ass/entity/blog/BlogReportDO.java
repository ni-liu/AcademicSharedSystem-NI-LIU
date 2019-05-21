package com.javaee.ass.entity.blog;

import com.javaee.ass.entity.enums.ReportedBlogOperationEnum;
import com.javaee.ass.entity.enums.ReportedBlogReasonEnum;
import org.apache.ibatis.type.Alias;

import java.sql.Date;
import java.util.Objects;

@Alias("blogReportDO")
public class BlogReportDO extends BlogActionDO {
   private int pkId;
   private ReportedBlogReasonEnum reason;
   private Date time;
   private ReportedBlogOperationEnum operation;

    public BlogReportDO() {
    }

    public int getPkId() {
        return this.pkId;
    }

    public ReportedBlogReasonEnum getReason() {
        return this.reason;
    }

    public Date getTime() {
        return this.time;
    }

    public ReportedBlogOperationEnum getOperation() {
        return this.operation;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public void setReason(ReportedBlogReasonEnum reason) {
        this.reason = reason;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setOperation(ReportedBlogOperationEnum operation) {
        this.operation = operation;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BlogReportDO)) return false;
        final BlogReportDO other = (BlogReportDO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.pkId != other.pkId) return false;
        final Object this$reason = this.reason;
        final Object other$reason = other.reason;
        if (!Objects.equals(this$reason, other$reason)) return false;
        final Object this$time = this.time;
        final Object other$time = other.time;
        if (!Objects.equals(this$time, other$time)) return false;
        final Object this$operation = this.operation;
        final Object other$operation = other.operation;
        return Objects.equals(this$operation, other$operation);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BlogReportDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.pkId;
        final Object $reason = this.reason;
        result = result * PRIME + ($reason == null ? 43 : $reason.hashCode());
        final Object $time = this.time;
        result = result * PRIME + ($time == null ? 43 : $time.hashCode());
        final Object $operation = this.operation;
        result = result * PRIME + ($operation == null ? 43 : $operation.hashCode());
        return result;
    }

    public String toString() {
        return "BlogReportDO(pkId=" + this.pkId + ", reason=" + this.reason + ", time=" + this.time + ", operation=" + this.operation + ")";
    }
}
