package com.javaee.ass.entity.typehandler;

import com.javaee.ass.entity.enums.BlogAuthorityEnum;
import com.javaee.ass.entity.enums.ReportedBlogReasonEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportBlogEnumTypeHandler implements TypeHandler<ReportedBlogReasonEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, ReportedBlogReasonEnum reportedBlogReasonEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i , reportedBlogReasonEnum.getReasonId());
    }

    @Override
    public ReportedBlogReasonEnum getResult(ResultSet resultSet, String s) throws SQLException {
        return ReportedBlogReasonEnum.getReason(resultSet.getInt(s));
    }

    @Override
    public ReportedBlogReasonEnum getResult(ResultSet resultSet, int i) throws SQLException {
        return ReportedBlogReasonEnum.getReason(resultSet.getInt(i));
    }

    @Override
    public ReportedBlogReasonEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        return ReportedBlogReasonEnum.getReason(callableStatement.getInt(i));
    }
}
