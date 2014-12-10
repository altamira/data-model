/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.bom;

import br.com.altamira.data.model.common.Material;
import java.util.Date;
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
public class BOMTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(BOM.class)
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
     * Test of getNumber method, of class BOM.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        BOM instance = new BOM();
        Long expResult = null;
        Long result = instance.getNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumber method, of class BOM.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        Long number = null;
        BOM instance = new BOM();
        instance.setNumber(number);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class BOM.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        BOM instance = new BOM();
        String expResult = "";
        String result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomer method, of class BOM.
     */
    @Test
    public void testSetCustomer() {
        System.out.println("setCustomer");
        String customer = "";
        BOM instance = new BOM();
        instance.setCustomer(customer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRepresentative method, of class BOM.
     */
    @Test
    public void testGetRepresentative() {
        System.out.println("getRepresentative");
        BOM instance = new BOM();
        String expResult = "";
        String result = instance.getRepresentative();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRepresentative method, of class BOM.
     */
    @Test
    public void testSetRepresentative() {
        System.out.println("setRepresentative");
        String representative = "";
        BOM instance = new BOM();
        instance.setRepresentative(representative);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreated method, of class BOM.
     */
    @Test
    public void testGetCreated() {
        System.out.println("getCreated");
        BOM instance = new BOM();
        Date expResult = null;
        Date result = instance.getCreated();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreated method, of class BOM.
     */
    @Test
    public void testSetCreated() {
        System.out.println("setCreated");
        Date created = null;
        BOM instance = new BOM();
        instance.setCreated(created);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDelivery method, of class BOM.
     */
    @Test
    public void testGetDelivery() {
        System.out.println("getDelivery");
        BOM instance = new BOM();
        Date expResult = null;
        Date result = instance.getDelivery();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDelivery method, of class BOM.
     */
    @Test
    public void testSetDelivery() {
        System.out.println("setDelivery");
        Date delivery = null;
        BOM instance = new BOM();
        instance.setDelivery(delivery);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuotation method, of class BOM.
     */
    @Test
    public void testGetQuotation() {
        System.out.println("getQuotation");
        BOM instance = new BOM();
        String expResult = "";
        String result = instance.getQuotation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuotation method, of class BOM.
     */
    @Test
    public void testSetQuotation() {
        System.out.println("setQuotation");
        String quotation = "";
        BOM instance = new BOM();
        instance.setQuotation(quotation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComment method, of class BOM.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        BOM instance = new BOM();
        String expResult = "";
        String result = instance.getComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComment method, of class BOM.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String comment = "";
        BOM instance = new BOM();
        instance.setComment(comment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFinish method, of class BOM.
     */
    @Test
    public void testGetFinish() {
        System.out.println("getFinish");
        BOM instance = new BOM();
        String expResult = "";
        String result = instance.getFinish();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFinish method, of class BOM.
     */
    @Test
    public void testSetFinish() {
        System.out.println("setFinish");
        String finish = "";
        BOM instance = new BOM();
        instance.setFinish(finish);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProject method, of class BOM.
     */
    @Test
    public void testGetProject() {
        System.out.println("getProject");
        BOM instance = new BOM();
        Long expResult = null;
        Long result = instance.getProject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProject method, of class BOM.
     */
    @Test
    public void testSetProject() {
        System.out.println("setProject");
        Long project = null;
        BOM instance = new BOM();
        instance.setProject(project);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItems method, of class BOM.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        BOM instance = new BOM();
        List<BOMItem> expResult = null;
        List<BOMItem> result = instance.getItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItems method, of class BOM.
     */
    @Test
    public void testSetItems() {
        System.out.println("setItems");
        List<BOMItem> items = null;
        BOM instance = new BOM();
        instance.setItems(items);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChecked method, of class BOM.
     */
    @Test
    public void testGetChecked() {
        System.out.println("getChecked");
        BOM instance = new BOM();
        Date expResult = null;
        Date result = instance.getChecked();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChecked method, of class BOM.
     */
    @Test
    public void testSetChecked() {
        System.out.println("setChecked");
        Date checked = null;
        BOM instance = new BOM();
        instance.setChecked(checked);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
