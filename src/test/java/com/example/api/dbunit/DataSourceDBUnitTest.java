package com.example.api.dbunit;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.InputStream;

@Service
public class DataSourceDBUnitTest {

    public static IDataSet getDataSet(String resourceName) throws Exception {
        InputStream datasetStream = DataSourceDBUnitTest.class.getClassLoader().getResourceAsStream(resourceName);
        if (datasetStream == null) {
            throw new IllegalArgumentException("Dataset not found: " + resourceName);
        }
        return new FlatXmlDataSetBuilder().build(datasetStream);
    }

    public static String getConnectionUrl() {
        return "jdbc:h2:mem:default;MODE=MYSQL;DB_CLOSE_DELAY=-1;init=runscript from 'classpath:schema.sql'";
    }

    protected DatabaseOperation getSetUpOperation() {
        return DatabaseOperation.REFRESH;
    }


    protected DatabaseOperation getTearDownOperation() {
        return DatabaseOperation.DELETE_ALL;
    }
}
