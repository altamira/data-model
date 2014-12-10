/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.manufacture.process;

import br.com.altamira.data.model.Entity;
import br.com.altamira.data.model.common.Material;
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
public class SketchTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(Sketch.class)
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
     * Test of setParent method, of class Sketch.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        Entity parent = null;
        Sketch instance = new Sketch();
        instance.setParent(parent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParent method, of class Sketch.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        Sketch instance = new Sketch();
        Entity expResult = null;
        Entity result = instance.getParent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFormat method, of class Sketch.
     */
    @Test
    public void testGetFormat() {
        System.out.println("getFormat");
        Sketch instance = new Sketch();
        String expResult = "";
        String result = instance.getFormat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFormat method, of class Sketch.
     */
    @Test
    public void testSetFormat() {
        System.out.println("setFormat");
        String format = "";
        Sketch instance = new Sketch();
        instance.setFormat(format);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFilename method, of class Sketch.
     */
    @Test
    public void testGetFilename() {
        System.out.println("getFilename");
        Sketch instance = new Sketch();
        String expResult = "";
        String result = instance.getFilename();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setgetFilename method, of class Sketch.
     */
    @Test
    public void testSetgetFilename() {
        System.out.println("setgetFilename");
        String filename = "";
        Sketch instance = new Sketch();
        instance.setgetFilename(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExtension method, of class Sketch.
     */
    @Test
    public void testGetExtension() {
        System.out.println("getExtension");
        Sketch instance = new Sketch();
        String expResult = "";
        String result = instance.getExtension();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExtension method, of class Sketch.
     */
    @Test
    public void testSetExtension() {
        System.out.println("setExtension");
        String extension = "";
        Sketch instance = new Sketch();
        instance.setExtension(extension);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImage method, of class Sketch.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        Sketch instance = new Sketch();
        byte[] expResult = null;
        byte[] result = instance.getImage();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImage method, of class Sketch.
     */
    @Test
    public void testSetImage() {
        System.out.println("setImage");
        byte[] image = null;
        Sketch instance = new Sketch();
        instance.setImage(image);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOperation method, of class Sketch.
     */
    @Test
    public void testGetOperation() {
        System.out.println("getOperation");
        Sketch instance = new Sketch();
        Operation expResult = null;
        Operation result = instance.getOperation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOperation method, of class Sketch.
     */
    @Test
    public void testSetOperation() {
        System.out.println("setOperation");
        Operation operation = null;
        Sketch instance = new Sketch();
        instance.setOperation(operation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
