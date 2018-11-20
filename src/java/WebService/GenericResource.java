/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import operaciones_pojo.DeparmentOp;
import operaciones_pojo.EmployeeOp;
import operaciones_pojo.RegionsOp;
import pojos.Regions;


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

    /**
     * GET method for query all the departments
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllDepartments")
    public String getAllDepartments(){
        String departamentos;
        DeparmentOp departOp = new DeparmentOp();    
        departamentos = departOp.leerTodos();
        return departamentos;
    }
    /**
     * GET method for query all the employes 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllEmployees")
    public String getAllEmployess() throws IOException{
        String empleados;
        EmployeeOp employeeOp = new EmployeeOp();
        empleados = employeeOp.leerTodos();
        return empleados;
    }
    /**
     * GET method for query all the regions
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("regions/getAllRegions")
    public String getAllRegions(){
        String regiones;
        RegionsOp regionOp = new RegionsOp();        
        regiones = regionOp.leerTodos();        
        return regiones;
    }
    /**
     * PUT method for create new regions
     * @param region
     * @return 
     */
    @Path("regions/createRegion")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createRegion(Regions region) {
        String respuesta;
        RegionsOp regionsOp = new RegionsOp();
        respuesta = regionsOp.crearRegion(region);
        return respuesta;
    }
}
