package com.javaee.ass.config;

import com.javaee.ass.config.property.JDBCProperties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    @Bean("dataSource")
    public static DataSource getDataSource() {
        BasicDataSource dataSource = null;
        try {
            // 通过 JDBCProperties类 配置数据库连接池
            dataSource = BasicDataSourceFactory.createDataSource(new JDBCProperties());
            dataSource.setDefaultAutoCommit(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dataSource;
    }

    @Bean("sqlSessionFactoryBean")
    public static SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return bean;
    }

    @Bean("txManager")
    public DataSourceTransactionManager getTxManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 通过扫描 DAO 和 Mapper 文件来代理生成动态 DAO
     * @return MapperScannerConfigurer
     */
    @Bean("mapperScannerConfigurer")
    public static MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        // 设置 DAO 类所在的包以供扫描
        msc.setBasePackage("com.javaee.ass.dao");
        // 以名称形式对于 SqlSessionFactoryBean 进行注入
        msc.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        return msc;
    }
}
