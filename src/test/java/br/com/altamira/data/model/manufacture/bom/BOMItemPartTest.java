/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.bom;

import br.com.altamira.data.model.Entity;
import br.com.altamira.data.model.common.Color;
import br.com.altamira.data.model.common.Material;
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
public class BOMItemPartTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(BOMItemPart.class)
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
     * Test of setParent method, of class BOMItemPart.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        Entity parent = null;
        BOMItemPart instance = new BOMItemPart();
        instance.setParent(parent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParent method, of class BOMItemPart.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        BOMItemPart instance = new BOMItemPart();
        Entity expResult = null;
        Entity result = instance.getParent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCode method, of class BOMItemPart.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        BOMItemPart instance = new BOMItemPart();
        String expResult = "";
        String result = instance.getCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCode method, of class BOMItemPart.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String code = "";
        BOMItemPart instance = new BOMItemPart();
        instance.setCode(code);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class BOMItemPart.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        BOMItemPart instance = new BOMItemPart();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class BOMItemPart.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        BOMItemPart instance = new BOMItemPart();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class BOMItemPart.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        BOMItemPart instance = new BOMItemPart();
        Color expResult = null;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class BOMItemPart.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Color color = null;
        BOMItemPart instance = new BOMItemPart();
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBOMItem method, of class BOMItemPart.
     */
    @Test
    public void testGetBOMItem() {
        System.out.println("getBOMItem");
        BOMItemPart instance = new BOMItemPart();
        BOMItem expResult = null;
        BOMItem result = instance.getBOMItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBOMItem method, of class BOMItemPart.
     */
    @Test
    public void testSetBOMItem() {
        System.out.println("setBOMItem");
        BOMItem bomItem = null;
        BOMItemPart instance = new BOMItemPart();
        instance.setBOMItem(bomItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class BOMItemPart.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        BOMItemPart instance = new BOMItemPart();
        Measure expResult = null;
        Measure result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class BOMItemPart.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        Measure quantity = null;
        BOMItemPart instance = new BOMItemPart();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class BOMItemPart.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        BOMItemPart instance = new BOMItemPart();
        Measure expResult = null;
        Measure result = instance.getWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWidth method, of class BOMItemPart.
     */
    @Test
    public void testSetWidth() {
        System.out.println("setWidth");
        Measure width = null;
        BOMItemPart instance = new BOMItemPart();
        instance.setWidth(width);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class BOMItemPart.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        BOMItemPart instance = new BOMItemPart();
        Measure expResult = null;
        Measure result = instance.getHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeight method, of class BOMItemPart.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        Measure height = null;
        BOMItemPart instance = new BOMItemPart();
        instance.setHeight(height);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLength method, of class BOMItemPart.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        BOMItemPart instance = new BOMItemPart();
        Measure expResult = null;
        Measure result = instance.getLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLength method, of class BOMItemPart.
     */
    @Test
    public void testSetLength() {
        System.out.println("setLength");
        Measure length = null;
        BOMItemPart instance = new BOMItemPart();
        instance.setLength(length);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeight method, of class BOMItemPart.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        BOMItemPart instance = new BOMItemPart();
        Measure expResult = null;
        Measure result = instance.getWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeight method, of class BOMItemPart.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        Measure weight = null;
        BOMItemPart instance = new BOMItemPart();
        instance.setWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
