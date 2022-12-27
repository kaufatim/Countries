package com.springboot.springbootcallingexternalapi.RestController;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.springboot.springbootcallingexternalapi.Service.callingExternalSerrvice;
import com.springboot.springbootcallingexternalapi.model.CallingExternalModel;
import com.springboot.springbootcallingexternalapi.Repository.callingExternalRepository;

@RestController
public class RestSpringBootController {
	private static Set fileData = null;
	private callingExternalSerrvice restCallingExternalSerrvice;
	private callingExternalRepository restcallingExternalRepository;
	
	@Autowired
	public RestSpringBootController(callingExternalSerrvice restCallingExternalSerrvice,callingExternalRepository restCallingExternalRepository){
		this.restCallingExternalSerrvice = restCallingExternalSerrvice;
		this.restcallingExternalRepository = restCallingExternalRepository; 
	}

	@RequestMapping("/hello")
	public String greeting( ) {
		
		return "hi";
	}
	
	@GetMapping("/callclienthi")
	private String getHiClient(CallingExternalModel model ) {
		String uri = "http://localhost:8080/hello";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		restcallingExternalRepository.save(model);
		return result;
	}
	
	@PostMapping("/sendtodatabase")
	public @ResponseBody String addDetails(CallingExternalModel model) {
		
		restcallingExternalRepository.save(model);
		return "New data saved" + model.toString();
		
		
	}
	
	@GetMapping("/callclientwiki")
	public List<Object> getCountriesClient() throws FileNotFoundException{
		
		String uri = "https://restcountries.com/v3.1/all";
		RestTemplate restTemplate = new RestTemplate();
		Object[] countries = restTemplate.getForObject(uri, Object[].class);
		fileData = restCallingExternalSerrvice.getDataFromFile(fileData);
		return Arrays.asList(countries);
		
	}
	
	/*
	@PostMapping("/getclientcountries")
	public void setCountriesData() {
		restCallingExternalSerrvice.callingExternalData();
	}
	*/
	
	
}
