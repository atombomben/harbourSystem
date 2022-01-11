/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Owner;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author peter
 */
public class OwnerTest extends TestCase {
    
    private static EntityManagerFactory emf;
    private static OwnerFacade facade;
    private static Owner o1;
    
    
    public OwnerTest() {
    }
    
     @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = OwnerFacade.getOwnerFacade(emf);
    }
    
    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }
    
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        o1 = new Owner("something","HH",50505050);
        
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Owner.deleteAllRows").executeUpdate();
            em.persist(o1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    @Test
    public void testGetPersonByAddress() {
        
        List<Owner> owners = facade.getAllOwnersFromEntity();
        assertEquals(1,owners.size());
       
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
}
