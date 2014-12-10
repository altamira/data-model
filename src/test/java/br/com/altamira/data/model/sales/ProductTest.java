/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.sales;

import br.com.altamira.data.model.common.Material;
import java.math.BigDecimal;
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
public class ProductTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(Product.class)
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
     * Test of getWidth method, of class Product.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Product instance = new Product();
        BigDecimal expResult = null;
        BigDecimal result = instance.getWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWidth method, of class Product.
     */
    @Test
    public void testSetWidth() {
        System.out.println("setWidth");
        BigDecimal width = null;
        Product instance = new Product();
        instance.setWidth(width);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class Product.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Product instance = new Product();
        BigDecimal expResult = null;
        BigDecimal result = instance.getHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeight method, of class Product.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        BigDecimal height = null;
        Product instance = new Product();
        instance.setHeight(height);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLength method, of class Product.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        Product instance = new Product();
        BigDecimal expResult = null;
        BigDecimal result = instance.getLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLength method, of class Product.
     */
    @Test
    public void testSetLength() {
        System.out.println("setLength");
        BigDecimal length = null;
        Product instance = new Product();
        instance.setLength(length);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeight method, of class Product.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        Product instance = new Product();
        BigDecimal expResult = null;
        BigDecimal result = instance.getWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeight method, of class Product.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        BigDecimal weight = null;
        Product instance = new Product();
        instance.setWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
