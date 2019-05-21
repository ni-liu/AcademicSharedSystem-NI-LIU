package com.javaee.ass.entity.typehandler;

import com.javaee.ass.entity.enums.AgreedEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgreedEnumTypeHandler implements TypeHandler<AgreedEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, AgreedEnum agreedEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i , agreedEnum.getAgreed());
    }

    @Override
    public AgreedEnum getResult(ResultSet resultSet, String s) throws SQLException {
        return AgreedEnum.getAgreeEnum(resultSet.getInt(s));
    }

    @Override
    public AgreedEnum getResult(ResultSet resultSet, int i) throws SQLException {
        return AgreedEnum.getAgreeEnum(resultSet.getInt(i));
    }

    @Override
    public AgreedEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        return AgreedEnum.getAgreeEnum(callableStatement.getInt(i));
    }
}
