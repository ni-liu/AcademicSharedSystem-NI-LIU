package com.javaee.ass.entity.typehandler;

import com.javaee.ass.entity.enums.BlogAuthorityEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorityEnumTypeHandler implements TypeHandler<BlogAuthorityEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, BlogAuthorityEnum authorityEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i , authorityEnum.getAuthority());
    }

    @Override
    public BlogAuthorityEnum getResult(ResultSet resultSet, String s) throws SQLException {
        return BlogAuthorityEnum.getAuthority(resultSet.getInt(s));
    }

    @Override
    public BlogAuthorityEnum getResult(ResultSet resultSet, int i) throws SQLException {
        return BlogAuthorityEnum.getAuthority(resultSet.getInt(i));
    }

    @Override
    public BlogAuthorityEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        return BlogAuthorityEnum.getAuthority(callableStatement.getInt(i));
    }
}
