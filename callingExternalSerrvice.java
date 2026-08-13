package com.springboot.springbootcallingexternalapi.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.springbootcallingexternalapi.Repository.callingExternalRepository;
import com.springboot.springbootcallingexternalapi.RestController.RestSpringBootController;
import com.springboot.springbootcallingexternalapi.model.CallingExternalModel;

@Service
public class callingExternalSerrvice {
	private callingExternalRepository restcallingExternalRepository;
	
	@Autowired
	public callingExternalSerrvice(callingExternalRepository restcallingExternalRepository) {
		this.restcallingExternalRepository = restcallingExternalRepository;
	}
	public void callingExternalData(CallingExternalModel restcallingExternalModel){	
		restcallingExternalRepository.save(restcallingExternalModel);
				
	}
	
	public void storeDataInFile() throws FileNotFoundException {
		String uri = "https://restcountries.com/v3.1/all";
		RestTemplate restTemplate = new RestTemplate();
		Object[] countries = restTemplate.getForObject(uri, Object[].class);
		File destinationFile = new File("C:/Users/bobbl/eclipse-workspace/externalAPIData.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			Scanner scan = new Scanner(destinationFile);
			fw = new FileWriter(destinationFile);
            bw = new BufferedWriter(fw);
            for(Object data:countries) {
            	String info = data.toString();
            	System.out.println(info);
            	bw.write(info);
            }
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Set<String> getDataFromFile(Set fileData){
		File srcFile = new File("C:/Users/bobbl/eclipse-workspace/externalAPIData.txt");
		FileReader fr;
		try {
			fr = new FileReader(srcFile);
			BufferedReader br = new BufferedReader(fr);
			String data;
			while((data = br.readLine()) != null )
			fileData.add(data);
			System.out.println(fileData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	

}
