package jp.rough_diamond.study.springboot;

import java.sql.ResultSet;
import java.sql.SQLException;

import jp.rough_diamond.study.springboot.domain.Customer;
import jp.rough_diamond.study.springboot.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {
	@Autowired
	CustomerService service;
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplte;
	
//	@RequestMapping("/")
//	String home() {
//		return "Hello World!!!!";
//	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		service.save(Customer.builder().id(1).firstName("Nobita").lastName("Nobi").build());
//		service.save(Customer.builder().id(2).firstName("Takeshi").lastName("Goda").build());
//		service.save(Customer.builder().id(3).firstName("Suneo").lastName("Honekawa").build());
//		
//		service.findAll().forEach(System.out::println);
		String sql = "select id, first_name, last_name from customers where id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", 1);
		Customer result = jdbcTemplte.queryForObject(sql, param, 
				(rs, rownum) ->  Customer.builder(
						).id(rs.getInt("id")
						).firstName(rs.getString("first_name")
						).lastName(rs.getString("last_name")).build()
		);
		System.out.println("result=" + result);
	}
}
