/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.purchase;

import br.com.altamira.data.model.common.Component;
import java.math.BigDecimal;
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
public class MaterialTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(Material.class)
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
     * Test of getLamination method, of class Material.
     */
    @Test
    public void testGetLamination() {
        System.out.println("getLamination");
        Material instance = new Material();
        String expResult = "";
        String result = instance.getLamination();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLamination method, of class Material.
     */
    @Test
    public void testSetLamination() {
        System.out.println("setLamination");
        String lamination = "";
        Material instance = new Material();
        instance.setLamination(lamination);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTreatment method, of class Material.
     */
    @Test
    public void testGetTreatment() {
        System.out.println("getTreatment");
        Material instance = new Material();
        String expResult = "";
        String result = instance.getTreatment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTreatment method, of class Material.
     */
    @Test
    public void testSetTreatment() {
        System.out.println("setTreatment");
        String treatment = "";
        Material instance = new Material();
        instance.setTreatment(treatment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getThickness method, of class Material.
     */
    @Test
    public void testGetThickness() {
        System.out.println("getThickness");
        Material instance = new Material();
        BigDecimal expResult = null;
        BigDecimal result = instance.getThickness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setThickness method, of class Material.
     */
    @Test
    public void testSetThickness() {
        System.out.println("setThickness");
        BigDecimal thickness = null;
        Material instance = new Material();
        instance.setThickness(thickness);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class Material.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Material instance = new Material();
        BigDecimal expResult = null;
        BigDecimal result = instance.getWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWidth method, of class Material.
     */
    @Test
    public void testSetWidth() {
        System.out.println("setWidth");
        BigDecimal width = null;
        Material instance = new Material();
        instance.setWidth(width);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLength method, of class Material.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        Material instance = new Material();
        BigDecimal expResult = null;
        BigDecimal result = instance.getLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLength method, of class Material.
     */
    @Test
    public void testSetLength() {
        System.out.println("setLength");
        BigDecimal length = null;
        Material instance = new Material();
        instance.setLength(length);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTax method, of class Material.
     */
    @Test
    public void testGetTax() {
        System.out.println("getTax");
        Material instance = new Material();
        BigDecimal expResult = null;
        BigDecimal result = instance.getTax();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTax method, of class Material.
     */
    @Test
    public void testSetTax() {
        System.out.println("setTax");
        BigDecimal tax = null;
        Material instance = new Material();
        instance.setTax(tax);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComponent method, of class Material.
     */
    @Test
    public void testGetComponent() {
        System.out.println("getComponent");
        Material instance = new Material();
        List<Component> expResult = null;
        List<Component> result = instance.getComponent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
