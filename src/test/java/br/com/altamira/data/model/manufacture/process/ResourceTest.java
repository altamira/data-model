/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.process;

import br.com.altamira.data.model.Entity;
import br.com.altamira.data.model.common.Material;
import br.com.altamira.data.model.measurement.Formula;
import br.com.altamira.data.model.measurement.Measure;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author Alessandro
 */
@RunWith(Arquillian.class)
public class ResourceTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(Resource.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                // Deploy our test datasource
                .addAsWebInfResource("test-ds.xml");
    }

    @Inject
    Logger log;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getOperation method, of class Resource.
     */
    @Test
    public void testGetOperation() {
        System.out.println("getOperation");
        Resource instance = new ResourceImpl();
        Operation expResult = null;
        Operation result = instance.getOperation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOperation method, of class Resource.
     */
    @Test
    public void testSetOperation() {
        System.out.println("setOperation");
        Operation operation = null;
        Resource instance = new ResourceImpl();
        instance.setOperation(operation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaterial method, of class Resource.
     */
    @Test
    public void testGetMaterial() {
        System.out.println("getMaterial");
        Resource instance = new ResourceImpl();
        Material expResult = null;
        Material result = instance.getMaterial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaterial method, of class Resource.
     */
    @Test
    public void testSetMaterial() {
        System.out.println("setMaterial");
        Material material = null;
        Resource instance = new ResourceImpl();
        instance.setMaterial(material);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class Resource.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Resource instance = new ResourceImpl();
        Measure expResult = null;
        Formula result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class Resource.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        Formula quantity = null;
        Resource instance = new ResourceImpl();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParent method, of class Resource.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        Entity parent = null;
        Resource instance = new ResourceImpl();
        instance.setParent(parent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParent method, of class Resource.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        Resource instance = new ResourceImpl();
        Entity expResult = null;
        Entity result = instance.getParent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ResourceImpl extends Resource {
    }
    
}
