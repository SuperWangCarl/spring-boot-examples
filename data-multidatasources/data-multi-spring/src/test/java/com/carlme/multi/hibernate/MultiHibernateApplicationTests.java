package com.carlme.multi.hibernate;

import com.carlme.multi.hibernate.datautil.DbContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class MultiHibernateApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void contextLoads() {
		System.out.println(jdbcTemplate);
		try {
			DbContextHolder.setDbType(DbContextHolder.DATA_SOURCE_MASTER);
			Map<String, Object> masterMap = jdbcTemplate.queryForMap("select count(*) sum from t_common_notice t ");
			System.out.println(masterMap);
			System.out.println("-------------------------------------------");
			DbContextHolder.setDbType(DbContextHolder.DATA_SOURCE_SLAVE);
			Map<String, Object> slaveMap = jdbcTemplate.queryForMap("select count(*) sum from t_common_notice t ");
			System.out.println(slaveMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
