package com.tuum.account;

import com.tuum.account.entity.Account;
import com.tuum.account.model.Balance;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes({Account.class, Balance.class})
@EnableRabbit
@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

}
