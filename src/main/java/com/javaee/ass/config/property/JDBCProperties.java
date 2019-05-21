package com.javaee.ass.config.property;

import com.javaee.ass.utils.FinalVariablesUtils;

import java.util.Properties;

public class JDBCProperties extends Properties {
    public JDBCProperties() {
        super.put("driver" , FinalVariablesUtils.ORACLE_JDBC_DRIVER);
        super.put("url" , FinalVariablesUtils.JDBC_URL);
        super.setProperty("username" , FinalVariablesUtils.DB_USER);
        super.setProperty("password" , FinalVariablesUtils.DB_PASSWORD);
    }
}
