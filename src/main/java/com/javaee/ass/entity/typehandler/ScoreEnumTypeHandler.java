package com.javaee.ass.entity.typehandler;

import com.javaee.ass.entity.enums.ScoreEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreEnumTypeHandler implements TypeHandler<ScoreEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, ScoreEnum scoreEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i , scoreEnum.getScore());
    }

    @Override
    public ScoreEnum getResult(ResultSet resultSet, String s) throws SQLException {
        return ScoreEnum.getScoreEnum(resultSet.getInt(s));
    }

    @Override
    public ScoreEnum getResult(ResultSet resultSet, int i) throws SQLException {
        return ScoreEnum.getScoreEnum(resultSet.getInt(i));
    }

    @Override
    public ScoreEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        return ScoreEnum.getScoreEnum(callableStatement.getInt(i));
    }
}
