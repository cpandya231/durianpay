
package com.chintan.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "updated",
    "country",
    "countryInfo",
    "cases",
    "todayCases",
    "deaths",
    "todayDeaths",
    "recovered",
    "todayRecovered",
    "active",
    "critical",
    "casesPerOneMillion",
    "deathsPerOneMillion",
    "tests",
    "testsPerOneMillion",
    "population",
    "continent",
    "oneCasePerPeople",
    "oneDeathPerPeople",
    "oneTestPerPeople",
    "activePerOneMillion",
    "recoveredPerOneMillion",
    "criticalPerOneMillion"
})
public class Covid19Datum {

    @JsonProperty("updated")
    private Long updated;
    @JsonProperty("country")
    private String country;
    @JsonProperty("countryInfo")
    private CountryInfo countryInfo;
    @JsonProperty("cases")
    private Long cases;
    @JsonProperty("todayCases")
    private Long todayCases;
    @JsonProperty("deaths")
    private Long deaths;
    @JsonProperty("todayDeaths")
    private Long todayDeaths;
    @JsonProperty("recovered")
    private Long recovered;
    @JsonProperty("todayRecovered")
    private Long todayRecovered;
    @JsonProperty("active")
    private Long active;
    @JsonProperty("critical")
    private Long critical;
    @JsonProperty("casesPerOneMillion")
    private Long casesPerOneMillion;
    @JsonProperty("deathsPerOneMillion")
    private Long deathsPerOneMillion;
    @JsonProperty("tests")
    private Long tests;
    @JsonProperty("testsPerOneMillion")
    private Long testsPerOneMillion;
    @JsonProperty("population")
    private Long population;
    @JsonProperty("continent")
    private String continent;
    @JsonProperty("oneCasePerPeople")
    private Long oneCasePerPeople;
    @JsonProperty("oneDeathPerPeople")
    private Long oneDeathPerPeople;
    @JsonProperty("oneTestPerPeople")
    private Long oneTestPerPeople;
    @JsonProperty("activePerOneMillion")
    private Double activePerOneMillion;
    @JsonProperty("recoveredPerOneMillion")
    private Double recoveredPerOneMillion;
    @JsonProperty("criticalPerOneMillion")
    private Long criticalPerOneMillion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("updated")
    public Long getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("countryInfo")
    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    @JsonProperty("countryInfo")
    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }

    @JsonProperty("cases")
    public Long getCases() {
        return cases;
    }

    @JsonProperty("cases")
    public void setCases(Long cases) {
        this.cases = cases;
    }

    @JsonProperty("todayCases")
    public Long getTodayCases() {
        return todayCases;
    }

    @JsonProperty("todayCases")
    public void setTodayCases(Long todayCases) {
        this.todayCases = todayCases;
    }

    @JsonProperty("deaths")
    public Long getDeaths() {
        return deaths;
    }

    @JsonProperty("deaths")
    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }

    @JsonProperty("todayDeaths")
    public Long getTodayDeaths() {
        return todayDeaths;
    }

    @JsonProperty("todayDeaths")
    public void setTodayDeaths(Long todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    @JsonProperty("recovered")
    public Long getRecovered() {
        return recovered;
    }

    @JsonProperty("recovered")
    public void setRecovered(Long recovered) {
        this.recovered = recovered;
    }

    @JsonProperty("todayRecovered")
    public Long getTodayRecovered() {
        return todayRecovered;
    }

    @JsonProperty("todayRecovered")
    public void setTodayRecovered(Long todayRecovered) {
        this.todayRecovered = todayRecovered;
    }

    @JsonProperty("active")
    public Long getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Long active) {
        this.active = active;
    }

    @JsonProperty("critical")
    public Long getCritical() {
        return critical;
    }

    @JsonProperty("critical")
    public void setCritical(Long critical) {
        this.critical = critical;
    }

    @JsonProperty("casesPerOneMillion")
    public Long getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    @JsonProperty("casesPerOneMillion")
    public void setCasesPerOneMillion(Long casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    @JsonProperty("deathsPerOneMillion")
    public Long getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    @JsonProperty("deathsPerOneMillion")
    public void setDeathsPerOneMillion(Long deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    @JsonProperty("tests")
    public Long getTests() {
        return tests;
    }

    @JsonProperty("tests")
    public void setTests(Long tests) {
        this.tests = tests;
    }

    @JsonProperty("testsPerOneMillion")
    public Long getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    @JsonProperty("testsPerOneMillion")
    public void setTestsPerOneMillion(Long testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    @JsonProperty("population")
    public Long getPopulation() {
        return population;
    }

    @JsonProperty("population")
    public void setPopulation(Long population) {
        this.population = population;
    }

    @JsonProperty("continent")
    public String getContinent() {
        return continent;
    }

    @JsonProperty("continent")
    public void setContinent(String continent) {
        this.continent = continent;
    }

    @JsonProperty("oneCasePerPeople")
    public Long getOneCasePerPeople() {
        return oneCasePerPeople;
    }

    @JsonProperty("oneCasePerPeople")
    public void setOneCasePerPeople(Long oneCasePerPeople) {
        this.oneCasePerPeople = oneCasePerPeople;
    }

    @JsonProperty("oneDeathPerPeople")
    public Long getOneDeathPerPeople() {
        return oneDeathPerPeople;
    }

    @JsonProperty("oneDeathPerPeople")
    public void setOneDeathPerPeople(Long oneDeathPerPeople) {
        this.oneDeathPerPeople = oneDeathPerPeople;
    }

    @JsonProperty("oneTestPerPeople")
    public Long getOneTestPerPeople() {
        return oneTestPerPeople;
    }

    @JsonProperty("oneTestPerPeople")
    public void setOneTestPerPeople(Long oneTestPerPeople) {
        this.oneTestPerPeople = oneTestPerPeople;
    }

    @JsonProperty("activePerOneMillion")
    public Double getActivePerOneMillion() {
        return activePerOneMillion;
    }

    @JsonProperty("activePerOneMillion")
    public void setActivePerOneMillion(Double activePerOneMillion) {
        this.activePerOneMillion = activePerOneMillion;
    }

    @JsonProperty("recoveredPerOneMillion")
    public Double getRecoveredPerOneMillion() {
        return recoveredPerOneMillion;
    }

    @JsonProperty("recoveredPerOneMillion")
    public void setRecoveredPerOneMillion(Double recoveredPerOneMillion) {
        this.recoveredPerOneMillion = recoveredPerOneMillion;
    }

    @JsonProperty("criticalPerOneMillion")
    public Long getCriticalPerOneMillion() {
        return criticalPerOneMillion;
    }

    @JsonProperty("criticalPerOneMillion")
    public void setCriticalPerOneMillion(Long criticalPerOneMillion) {
        this.criticalPerOneMillion = criticalPerOneMillion;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
