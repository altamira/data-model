/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.order;

import br.com.altamira.data.model.common.Material;
import java.util.List;
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
public class OrderItemTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(OrderItem.class)
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
     * Test of getOrder method, of class OrderItem.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        OrderItem instance = new OrderItem();
        Order expResult = null;
        Order result = instance.getOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrder method, of class OrderItem.
     */
    @Test
    public void testSetOrder() {
        System.out.println("setOrder");
        Order order = null;
        OrderItem instance = new OrderItem();
        instance.setOrder(order);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class OrderItem.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        OrderItem instance = new OrderItem();
        int expResult = 0;
        int result = instance.getItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItem method, of class OrderItem.
     */
    @Test
    public void testSetItem() {
        System.out.println("setItem");
        int item = 0;
        OrderItem instance = new OrderItem();
        instance.setItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class OrderItem.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        OrderItem instance = new OrderItem();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class OrderItem.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        OrderItem instance = new OrderItem();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParts method, of class OrderItem.
     */
    @Test
    public void testGetParts() {
        System.out.println("getParts");
        OrderItem instance = new OrderItem();
        List<OrderItemPart> expResult = null;
        List<OrderItemPart> result = instance.getParts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPart method, of class OrderItem.
     */
    @Test
    public void testSetPart() {
        System.out.println("setPart");
        List<OrderItemPart> parts = null;
        OrderItem instance = new OrderItem();
        instance.setPart(parts);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
