/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos.mssgRequestAnswers;

import java.util.List;
import pojos.Countries;

/**
 *
 * @author kalav
 */
public class CountriesList {
    List<Countries> data;

    public CountriesList() {
    }

    public CountriesList(List<Countries> data) {
        this.data = data;
    }
}
