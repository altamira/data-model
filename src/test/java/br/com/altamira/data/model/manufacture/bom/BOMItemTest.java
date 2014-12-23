/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.bom;

import br.com.altamira.data.model.Entity;
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
public class BOMItemTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(BOMItem.class)
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
     * Test of setParent method, of class BOMItem.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        Entity parent = null;
        BOMItem instance = new BOMItem();
        instance.setParent(parent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParent method, of class BOMItem.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        BOMItem instance = new BOMItem();
        Entity expResult = null;
        Entity result = instance.getParent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBOM method, of class BOMItem.
     */
    @Test
    public void testGetBOM() {
        System.out.println("getBOM");
        BOMItem instance = new BOMItem();
        BOM expResult = null;
        BOM result = instance.getBOM();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBOM method, of class BOMItem.
     */
    @Test
    public void testSetBOM() {
        System.out.println("setBOM");
        BOM bom = null;
        BOMItem instance = new BOMItem();
        instance.setBOM(bom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class BOMItem.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        BOMItem instance = new BOMItem();
        int expResult = 0;
        int result = instance.getItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItem method, of class BOMItem.
     */
    @Test
    public void testSetItem() {
        System.out.println("setItem");
        int item = 0;
        BOMItem instance = new BOMItem();
        instance.setItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class BOMItem.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        BOMItem instance = new BOMItem();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class BOMItem.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        BOMItem instance = new BOMItem();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParts method, of class BOMItem.
     */
    @Test
    public void testGetParts() {
        System.out.println("getParts");
        BOMItem instance = new BOMItem();
        List<BOMItemPart> expResult = null;
        List<BOMItemPart> result = instance.getParts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPart method, of class BOMItem.
     */
    @Test
    public void testSetPart() {
        System.out.println("setPart");
        List<BOMItemPart> parts = null;
        BOMItem instance = new BOMItem();
        instance.setPart(parts);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
