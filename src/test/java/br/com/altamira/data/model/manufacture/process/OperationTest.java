/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.process;

import br.com.altamira.data.model.Entity;
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
public class OperationTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(Operation.class)
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
     * Test of setParent method, of class Operation.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        Entity parent = null;
        Operation instance = new Operation();
        instance.setParent(parent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParent method, of class Operation.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        Operation instance = new Operation();
        Entity expResult = null;
        Entity result = instance.getParent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProcess method, of class Operation.
     */
    @Test
    public void testGetProcess() {
        System.out.println("getProcess");
        Operation instance = new Operation();
        Process expResult = null;
        Process result = instance.getProcess();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProcess method, of class Operation.
     */
    @Test
    public void testSetProcess() {
        System.out.println("setProcess");
        Process process = null;
        Operation instance = new Operation();
        instance.setProcess(process);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSequence method, of class Operation.
     */
    @Test
    public void testGetSequence() {
        System.out.println("getSequence");
        Operation instance = new Operation();
        int expResult = 0;
        int result = instance.getSequence();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSequence method, of class Operation.
     */
    @Test
    public void testSetSequence() {
        System.out.println("setSequence");
        int sequence = 0;
        Operation instance = new Operation();
        instance.setSequence(sequence);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Operation.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Operation instance = new Operation();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Operation.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Operation instance = new Operation();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Operation.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Operation instance = new Operation();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Operation.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Operation instance = new Operation();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSketch method, of class Operation.
     */
    @Test
    public void testGetSketch() {
        System.out.println("getSketch");
        Operation instance = new Operation();
        Sketch expResult = null;
        Sketch result = instance.getSketch();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSketch method, of class Operation.
     */
    @Test
    public void testSetSketch() {
        System.out.println("setSketch");
        Sketch sketch = null;
        Operation instance = new Operation();
        instance.setSketch(sketch);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUse method, of class Operation.
     */
    @Test
    public void testGetUse() {
        System.out.println("getUse");
        Operation instance = new Operation();
        List<Use> expResult = null;
        List<Use> result = instance.getUse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUse method, of class Operation.
     */
    @Test
    public void testSetUse() {
        System.out.println("setUse");
        List<Use> use = null;
        Operation instance = new Operation();
        instance.setUse(use);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsume method, of class Operation.
     */
    @Test
    public void testGetConsume() {
        System.out.println("getConsume");
        Operation instance = new Operation();
        List<Consume> expResult = null;
        List<Consume> result = instance.getConsume();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConsume method, of class Operation.
     */
    @Test
    public void testSetConsume() {
        System.out.println("setConsume");
        List<Consume> consume = null;
        Operation instance = new Operation();
        instance.setConsume(consume);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProduce method, of class Operation.
     */
    @Test
    public void testGetProduce() {
        System.out.println("getProduce");
        Operation instance = new Operation();
        List<Produce> expResult = null;
        List<Produce> result = instance.getProduce();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProduce method, of class Operation.
     */
    @Test
    public void testSetProduce() {
        System.out.println("setProduce");
        List<Produce> produce = null;
        Operation instance = new Operation();
        instance.setProduce(produce);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
