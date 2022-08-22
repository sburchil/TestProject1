package com.sym.tracking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		String sql = "INSERT INTO courier_tracking (OrderId, Courier, TrackingNumber, RecordIdentifier) VALUES (?, ?, ?, ?)";
//		int result = jdbcTemplate.update(sql, "5117", "FedEx", "1233211233211", "RF0000003");
//		
//		if(result > 0) {
//			System.out.println("a new row has been inserted.");
//		}
	}

}
