/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.sales;

import br.com.altamira.data.model.common.Color;
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
public class OrderItemPartTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(OrderItemPart.class)
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
     * Test of getColor method, of class OrderItemPart.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        OrderItemPart instance = new OrderItemPart();
        Color expResult = null;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class OrderItemPart.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Color color = null;
        OrderItemPart instance = new OrderItemPart();
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class OrderItemPart.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        OrderItemPart instance = new OrderItemPart();
        BigDecimal expResult = null;
        BigDecimal result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class OrderItemPart.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        BigDecimal quantity = null;
        OrderItemPart instance = new OrderItemPart();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class OrderItemPart.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        OrderItemPart instance = new OrderItemPart();
        BigDecimal expResult = null;
        BigDecimal result = instance.getWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWidth method, of class OrderItemPart.
     */
    @Test
    public void testSetWidth() {
        System.out.println("setWidth");
        BigDecimal width = null;
        OrderItemPart instance = new OrderItemPart();
        instance.setWidth(width);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class OrderItemPart.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        OrderItemPart instance = new OrderItemPart();
        BigDecimal expResult = null;
        BigDecimal result = instance.getHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeight method, of class OrderItemPart.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        BigDecimal height = null;
        OrderItemPart instance = new OrderItemPart();
        instance.setHeight(height);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLength method, of class OrderItemPart.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        OrderItemPart instance = new OrderItemPart();
        BigDecimal expResult = null;
        BigDecimal result = instance.getLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLength method, of class OrderItemPart.
     */
    @Test
    public void testSetLength() {
        System.out.println("setLength");
        BigDecimal length = null;
        OrderItemPart instance = new OrderItemPart();
        instance.setLength(length);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeight method, of class OrderItemPart.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        OrderItemPart instance = new OrderItemPart();
        BigDecimal expResult = null;
        BigDecimal result = instance.getWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeight method, of class OrderItemPart.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        BigDecimal weight = null;
        OrderItemPart instance = new OrderItemPart();
        instance.setWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderItem method, of class OrderItemPart.
     */
    @Test
    public void testGetOrderItem() {
        System.out.println("getOrderItem");
        OrderItemPart instance = new OrderItemPart();
        OrderItem expResult = null;
        OrderItem result = instance.getOrderItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderItem method, of class OrderItemPart.
     */
    @Test
    public void testSetOrderItem() {
        System.out.println("setOrderItem");
        OrderItem orderItem = null;
        OrderItemPart instance = new OrderItemPart();
        instance.setOrderItem(orderItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
