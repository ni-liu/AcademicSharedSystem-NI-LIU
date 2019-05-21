package com.javaee.ass.config.property;

import java.util.Properties;

public class JDBCProperties extends Properties {
    public JDBCProperties() {
        super.put("driver" , "oracle.jdbc.OracleDriver");
        super.put("url" , "jdbc:oracle:thin:@localhost:1521:orcl");
        super.setProperty("username","spider_men");
        super.setProperty("password","hail_hydra");
    }
}
