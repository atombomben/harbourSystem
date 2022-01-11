/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.OwnerDTO;
import errorhandling.API_Exception;
import facades.OwnerFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 *
 * @author peter
 */

@Path("owner")
public class OwnerResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final OwnerFacade FACADE =  OwnerFacade.getOwnerFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Welcome to OwnerPage\"}";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("show")
    public Response showOwners() throws API_Exception {
        List<OwnerDTO> ownerDTOs = OwnerDTO.getDTOs(FACADE.getAllOwnersFromEntity());
        return Response.ok().entity(GSON.toJson(ownerDTOs)).build();
    }
    
}
