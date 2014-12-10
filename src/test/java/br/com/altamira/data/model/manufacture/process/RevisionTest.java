/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.process;

import br.com.altamira.data.model.Entity;
import br.com.altamira.data.model.common.Material;
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
public class RevisionTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(Revision.class)
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
     * Test of setParent method, of class Revision.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        Entity parent = null;
        Revision instance = new Revision();
        instance.setParent(parent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParent method, of class Revision.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        Revision instance = new Revision();
        Entity expResult = null;
        Entity result = instance.getParent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProcess method, of class Revision.
     */
    @Test
    public void testGetProcess() {
        System.out.println("getProcess");
        Revision instance = new Revision();
        Process expResult = null;
        Process result = instance.getProcess();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProcess method, of class Revision.
     */
    @Test
    public void testSetProcess() {
        System.out.println("setProcess");
        Process process = null;
        Revision instance = new Revision();
        instance.setProcess(process);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Revision.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Revision instance = new Revision();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Revision.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Revision instance = new Revision();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBy method, of class Revision.
     */
    @Test
    public void testGetBy() {
        System.out.println("getBy");
        Revision instance = new Revision();
        String expResult = "";
        String result = instance.getBy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBy method, of class Revision.
     */
    @Test
    public void testSetBy() {
        System.out.println("setBy");
        String by = "";
        Revision instance = new Revision();
        instance.setBy(by);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
