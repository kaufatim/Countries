package com.springboot.springbootcallingexternalapi.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class CallingExternalModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "common")
	private String common;
	
	@Column(name = "official")
	private String official;
	
	@Column(name = "currencies")
	private String currencies;;
	
	@Column(name = "capital")
	private String capital;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "languages")
	private String languages;

	public CallingExternalModel(long id,String common,String official, String currencies, String capital,
			String region, String languages) {
		
		super();
		this.common = common;
		this.official = official;
		this.currencies = currencies;
		this.capital = capital;
		this.region = region;
		this.languages = languages;
		this.id = id;
	}
	
	public CallingExternalModel() {
		super();
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	public String getOfficial() {
		return official;
	}

	public void setOfficial(String official) {
		this.official = official;
	}

	public String getCurrencies() {
		return currencies;
	}

	public void setCurrencies(String currencies) {
		this.currencies = currencies;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
}
