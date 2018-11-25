/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import operaciones_pojo.CountriesOP;
import operaciones_pojo.RegionsOp;
import pojos.Countries;


/**
 * REST Web Service
 *
 * @author kalav
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("regions/getAllRegions")
    public String getAllRegions(){
        String regiones;
        RegionsOp regionsOp = new RegionsOp();        
        regiones = regionsOp.leerTodos();          
        return regiones;
    }
    /**
     * GET method for query all the counstries
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countries/getAllCountries")
    public String getAllCountries(){
        String paises;
        CountriesOP countriesOp = new CountriesOP();        
        paises = countriesOp.getAllCountries();  
        System.out.println(paises);
        return paises;
    }
    /**
     * POST method for create new regions
     * @param countries
     * @return 
     */
    @Path("countries/createCountries")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createCountry(Countries countries) {
        String respuesta;
        CountriesOP countriesOP = new CountriesOP();
        respuesta = countriesOP.crearCountry(countries);
        return respuesta;
    }
    /**
     * PUT method for delete new regions
     * @param countries
     * @return 
     */    
    @Path("countries/deleteCountries")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public String deleteCountry(Countries countries){
        String respuesta;
        CountriesOP countriesOP = new CountriesOP();
        respuesta = countriesOP.deleteCountry(countries.getCountry_id());
        return respuesta;
    }
    
    /**
     * PUT method for update countries
     * @param countries
     * @return 
     */
    @Path("countries/updateCountries")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateCountry(Countries countries) {
        String respuesta;
        CountriesOP countriesOP = new CountriesOP();
        respuesta = countriesOP.updateCountry(countries);
        return respuesta;
    }
  
}
