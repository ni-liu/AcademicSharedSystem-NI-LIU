package com.javaee.ass.entity.typehandler;

import com.javaee.ass.entity.enums.RoleEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleEnumTypeHandler implements TypeHandler<RoleEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, RoleEnum roleEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i , roleEnum.getRoleId());
    }

    @Override
    public RoleEnum getResult(ResultSet resultSet, String s) throws SQLException {
        return RoleEnum.getRole(resultSet.getInt(s));
    }

    @Override
    public RoleEnum getResult(ResultSet resultSet, int i) throws SQLException {
        return RoleEnum.getRole(resultSet.getInt(i));
    }

    @Override
    public RoleEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        return RoleEnum.getRole(callableStatement.getInt(i));
    }
}
