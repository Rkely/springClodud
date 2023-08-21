package com.appsdeveloperblog.photoapp.api.users;

import com.appsdeveloperblog.photoapp.api.users.data.UserEntity;
import com.appsdeveloperblog.photoapp.api.users.data.UsersRepository;
import com.appsdeveloperblog.photoapp.api.users.shared.FeignErrorDecoder;
import com.appsdeveloperblog.photoapp.api.users.shared.UserDto;
import feign.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.UUID;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
////import org.springframework.cloud.openfeign.EnableFeignClients;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Profile;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.client.RestTemplate;
//
////import com.appsdeveloperblog.photoapp.api.users.shared.FeignErrorDecoder;
//
////import feign.Logger;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableCircuitBreaker
public class PhotoAppApiUsersApplication //implements CommandLineRunner
 {

	@Autowired
	Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiUsersApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	//@Profile("!production")
	Logger.Level feignDefaultLoggerLevel()
	{
		return Logger.Level.FULL;
	}

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
	UsersRepository usersRepository;
//	@Override
//	public void run(String... args) throws Exception {
//		UserDto userDetails = new UserDto();
//		userDetails.setPassword("123456");
//		userDetails.setEmail("test123test@gmail.com");
//		userDetails.setFirstName("iiis");
//		userDetails.setLastName("lll");
//		userDetails.setUserId(UUID.randomUUID().toString());
//		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
//
//		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//
//		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
//
//		usersRepository.save(userEntity);
//	}
	/*@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	@Bean
	@Profile("production")
	Logger.Level feignLoggerLevel()
	{
		return Logger.Level.NONE;
	}


	@Bean
	@Profile("production")
	public String createProductionBean() {
		System.out.println("Production bean created. myapplication.environment = " + environment.getProperty("myapplication.environment"));
		return "Production bean";
	}
	
	@Bean
	@Profile("!production")
	public String createNotProductionBean() {
		System.out.println("Not Production bean created. myapplication.environment = " + environment.getProperty("myapplication.environment"));
		return "Not production bean";
	}
	
	@Bean
	@Profile("default")
	public String createDevelopmentBean() {
		System.out.println("Development bean created. myapplication.environment = " + environment.getProperty("myapplication.environment"));
		return "Development bean";
	}
	*/

//	@Bean
//	public FeignErrorDecoder getFeignErrorDecoder()
//	{
//		return new FeignErrorDecoder();
//	}

}
