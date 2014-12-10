/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.purchase;

import java.util.Date;
import java.util.Set;
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
public class RequestTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(Request.class)
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
     * Test of getCreated method, of class Request.
     */
    @Test
    public void testGetCreated() {
        System.out.println("getCreated");
        Request instance = new Request();
        Date expResult = null;
        Date result = instance.getCreated();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreated method, of class Request.
     */
    @Test
    public void testSetCreated() {
        System.out.println("setCreated");
        Date created = null;
        Request instance = new Request();
        instance.setCreated(created);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreator method, of class Request.
     */
    @Test
    public void testGetCreator() {
        System.out.println("getCreator");
        Request instance = new Request();
        String expResult = "";
        String result = instance.getCreator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreator method, of class Request.
     */
    @Test
    public void testSetCreator() {
        System.out.println("setCreator");
        String creator = "";
        Request instance = new Request();
        instance.setCreator(creator);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSent method, of class Request.
     */
    @Test
    public void testGetSent() {
        System.out.println("getSent");
        Request instance = new Request();
        Date expResult = null;
        Date result = instance.getSent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSent method, of class Request.
     */
    @Test
    public void testSetSent() {
        System.out.println("setSent");
        Date sent = null;
        Request instance = new Request();
        instance.setSent(sent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class Request.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        Request instance = new Request();
        Set<RequestItem> expResult = null;
        Set<RequestItem> result = instance.getItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItem method, of class Request.
     */
    @Test
    public void testSetItem() {
        System.out.println("setItem");
        Set<RequestItem> items = null;
        Request instance = new Request();
        instance.setItem(items);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
