/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
import org.junit.runner.RunWith;

import br.com.altamira.data.model.manufacture.bom.Component;

@RunWith(Arquillian.class)
public class OrderItemComponentTest {

	@Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(Order.class)
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
     * Test of getOrder method, of class OrderItemComponent.
     */
    @Test
    public void testGetOrder() {
    	System.out.println("getOrder");
    	OrderItemComponent instance = new OrderItemComponent();
    	Order expResult = null;
    	Order result = instance.getOrder();
    	assertEquals(expResult, result);
    	// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of setOrder method, of class OrderItemComponent.
     */
    @Test
    public void testSetOrder() {
    	System.out.println("setOrder");
    	Order order = null;
    	OrderItemComponent instance = new OrderItemComponent();
    	instance.setOrder(order);
    	// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of getComponent method, of class OrderItemComponent.
     */
    @Test
    public void testGetComponent() {
    	System.out.println("getComponent");
    	OrderItemComponent instance = new OrderItemComponent();
    	Component expResult = null;
    	Component result = instance.getComponent();
    	assertEquals(expResult, result);
    	// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of setComponent method, of class OrderItemComponent.
     */
    @Test
    public void testSetComponent() {
    	System.out.println("setComponent");
    	Component component = null;
    	OrderItemComponent instance = new OrderItemComponent();
    	instance.setComponent(component);
    	// TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of getStartDate method, of class OrderItemComponent.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        OrderItemComponent instance = new OrderItemComponent();
        Date expResult = null;
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of setStartDate method, of class OrderItemComponent.
     */
    @Test
    public void testSetStartDate() {
    	System.out.println("setStartDate");
        Date startDate = null;
        OrderItemComponent instance = new OrderItemComponent();
        instance.setStartDate(startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
}
