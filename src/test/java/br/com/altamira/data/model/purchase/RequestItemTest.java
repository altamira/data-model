/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.purchase;

import java.math.BigDecimal;
import java.util.Date;
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
public class RequestItemTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(RequestItem.class)
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
     * Test of getArrival method, of class RequestItem.
     */
    @Test
    public void testGetArrival() {
        System.out.println("getArrival");
        RequestItem instance = new RequestItem();
        Date expResult = null;
        Date result = instance.getArrival();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArrival method, of class RequestItem.
     */
    @Test
    public void testSetArrival() {
        System.out.println("setArrival");
        Date arrival = null;
        RequestItem instance = new RequestItem();
        instance.setArrival(arrival);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeight method, of class RequestItem.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        RequestItem instance = new RequestItem();
        BigDecimal expResult = null;
        BigDecimal result = instance.getWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeight method, of class RequestItem.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        BigDecimal weight = null;
        RequestItem instance = new RequestItem();
        instance.setWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequest method, of class RequestItem.
     */
    @Test
    public void testGetRequest() {
        System.out.println("getRequest");
        RequestItem instance = new RequestItem();
        Request expResult = null;
        Request result = instance.getRequest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRequest method, of class RequestItem.
     */
    @Test
    public void testSetRequest() {
        System.out.println("setRequest");
        Request request = null;
        RequestItem instance = new RequestItem();
        instance.setRequest(request);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaterial method, of class RequestItem.
     */
    @Test
    public void testGetMaterial() {
        System.out.println("getMaterial");
        RequestItem instance = new RequestItem();
        Material expResult = null;
        Material result = instance.getMaterial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaterial method, of class RequestItem.
     */
    @Test
    public void testSetMaterial() {
        System.out.println("setMaterial");
        Material material = null;
        RequestItem instance = new RequestItem();
        instance.setMaterial(material);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
