package com.ribeiro.picpaychallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@SpringBootApplication
@EnableJdbcAuditing
public class PicpayChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicpayChallengeApplication.class, args);
	}

}
