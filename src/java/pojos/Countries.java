/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author kalav
 */
public class Countries {
    String country_id;
    String country_name;
    int region_id;
    String region_name;

    public Countries() {
    }

    public Countries(String Country_id, String Country_name, int region_id, String region_name) {
        this.country_id = Country_id;
        this.country_name = Country_name;
        this.region_id = region_id;
        this.region_name = region_name;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String Country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String Country_name) {
        this.country_name = country_name;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    
    
    
    
}
