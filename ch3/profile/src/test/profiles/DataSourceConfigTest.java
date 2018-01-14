package profiles;

import com.jihite.DataSourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

public class DataSourceConfigTest {

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = DataSourceConfig.class)
    @ActiveProfiles("dev")
    public static class DevDataSourceTest {
        @Autowired
        DataSource dataSource;
        @Test
        public void shouldBeEmbededDataSource() {
            assertNotNull(dataSource);
            JdbcTemplate jdbcTemplate =  new JdbcTemplate(dataSource);
            List<String> results = jdbcTemplate.query("select id, name from Things", new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                    return resultSet.getLong("id") + ":" + resultSet.getString("name");
                }
            });

            assertEquals(1, results.size());
            assertEquals("1:A", results.get(0));
        }
    }


    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration("classpath:dataSource-config.xml")
    @ActiveProfiles("dev")
    public static class DevDataSourceXMLTest {
        @Autowired
        DataSource dataSource;
        @Test
        public void shouldBeEmbededDataSource() {
            assertNotNull(dataSource);
            JdbcTemplate jdbcTemplate =  new JdbcTemplate(dataSource);
            List<String> results = jdbcTemplate.query("select id, name from Things", new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                    return resultSet.getLong("id") + ":" + resultSet.getString("name");
                }
            });

            assertEquals(1, results.size());
            assertEquals("1:A", results.get(0));
        }
    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = DataSourceConfig.class)
    @ActiveProfiles("prod")
    public static class ProdDataSourceTest {
        @Autowired
        DataSource dataSource;

        @Test
        public void shouldBeEmbededDataSource() {
            assertNull(dataSource);
        }
    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = DataSourceConfig.class)
    @ActiveProfiles("prod")
    public static class ProdDataSourceXMLTest {
        @Autowired
        DataSource dataSource;

        @Test
        public void shouldBeEmbededDataSource() {
            assertNull(dataSource);
        }
    }
}
