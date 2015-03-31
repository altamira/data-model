/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.process;

import br.com.altamira.data.model.common.Material;
import br.com.altamira.data.model.sales.Component;

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
public class ProcessTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(Process.class)
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
     * Test of getCode method, of class Process.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        Process instance = new Process();
        String expResult = "";
        String result = instance.getCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCode method, of class Process.
     */
    @Test
    public void testSetCode() {
        System.out.println("setCode");
        String code = "";
        Process instance = new Process();
        instance.setCode(code);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Process.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Process instance = new Process();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Process.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Process instance = new Process();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRevision method, of class Process.
     */
    @Test
    public void testGetRevision() {
        System.out.println("getRevision");
        Process instance = new Process();
        List<Revision> expResult = null;
        List<Revision> result = instance.getRevision();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRevision method, of class Process.
     */
    @Test
    public void testSetRevision() {
        System.out.println("setRevision");
        List<Revision> revision = null;
        Process instance = new Process();
        instance.setRevision(revision);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOperation method, of class Process.
     */
    @Test
    public void testGetOperation() {
        System.out.println("getOperation");
        Process instance = new Process();
        List<Operation> expResult = null;
        List<Operation> result = instance.getOperation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOperation method, of class Process.
     */
    @Test
    public void testSetOperation() {
        System.out.println("setOperation");
        List<Operation> operation = null;
        Process instance = new Process();
        instance.setOperation(operation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of getComponent method, of class Process.
     */
    @Test
    public void testGetComponent() {
    	System.out.println("getComponent");
        Process instance = new Process();
        List<Material> expResult = null;
        List<Material> result = instance.getMaterial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of setComponent method, of class Process.
     */
    @Test
    public void testSetComponent() {
    	System.out.println("setComponent");
        List<Material> material = null;
        Process instance = new Process();
        instance.setMaterial(material);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of getName method, of class Process.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Process instance = new Process();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Process.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Process instance = new Process();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
