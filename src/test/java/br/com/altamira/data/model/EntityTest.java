/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model;

import br.com.altamira.data.model.common.Material;
import java.sql.Timestamp;
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
public class EntityTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(Entity.class)
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
     * Test of getId method, of class Entity.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Entity instance = new EntityImpl();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Entity.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Entity instance = new EntityImpl();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParent method, of class Entity.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        Entity instance = new EntityImpl();
        Entity expResult = null;
        Entity result = instance.getParent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParent method, of class Entity.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        Entity parent = null;
        Entity instance = new EntityImpl();
        instance.setParent(parent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParentType method, of class Entity.
     */
    @Test
    public void testSetParentType() {
        System.out.println("setParentType");
        Class<? extends BaseEntity> parentType = null;
        Entity instance = new EntityImpl();
        instance.setParentType(parentType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParentType method, of class Entity.
     */
    @Test
    public void testGetParentType() {
        System.out.println("getParentType");
        Entity instance = new EntityImpl();
        Class<? extends Entity> expResult = null;
        Class<? extends Entity> result = instance.getParentType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVersion method, of class Entity.
     */
    @Test
    public void testGetVersion() {
        System.out.println("getVersion");
        Entity instance = new EntityImpl();
        Timestamp expResult = null;
        Timestamp result = instance.getVersion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVersion method, of class Entity.
     */
    @Test
    public void testSetVersion() {
        System.out.println("setVersion");
        Timestamp version = null;
        Entity instance = new EntityImpl();
        instance.setVersion(version);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Entity.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Entity instance = new EntityImpl();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Entity.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Entity instance = new EntityImpl();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Entity.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Entity instance = new EntityImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class EntityImpl implements Entity {

        public Long getId() {
            return null;
        }

        public void setId(Long id) {
        }

        public Entity getParent() {
            return null;
        }

        public void setParent(Entity parent) {
        }

        public void setParentType(Class<? extends BaseEntity> parentType) {
        }

        public Class<? extends Entity> getParentType() {
            return null;
        }

        public Timestamp getVersion() {
            return null;
        }

        public void setVersion(Timestamp version) {
        }

        public int hashCode() {
            return 0;
        }

        public boolean equals(Object object) {
            return false;
        }

        public String toString() {
            return "";
        }
    }
    
}
