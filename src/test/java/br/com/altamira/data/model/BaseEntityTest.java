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
public class BaseEntityTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(BaseEntityImpl.class)
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
     * Test of getSerialVersionUID method, of class BaseEntity.
     */
    @Test
    public void testGetSerialVersionUID() {
        System.out.println("getSerialVersionUID");
        long expResult = 0L;
        long result = BaseEntity.getSerialVersionUID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateModificationTimestamp method, of class BaseEntity.
     */
    @Test
    public void testUpdateModificationTimestamp() {
        System.out.println("updateModificationTimestamp");
        BaseEntity instance = new BaseEntityImpl();
        instance.updateModificationTimestamp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVersion method, of class BaseEntity.
     */
    @Test
    public void testGetVersion() {
        System.out.println("getVersion");
        BaseEntity instance = new BaseEntityImpl();
        Timestamp expResult = null;
        Timestamp result = instance.getVersion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVersion method, of class BaseEntity.
     */
    @Test
    public void testSetVersion() {
        System.out.println("setVersion");
        Timestamp version = null;
        BaseEntity instance = new BaseEntityImpl();
        instance.setVersion(version);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParentType method, of class BaseEntity.
     */
    @Test
    public void testGetParentType() {
        System.out.println("getParentType");
        BaseEntity instance = new BaseEntityImpl();
        Class<? extends Entity> expResult = null;
        Class<? extends Entity> result = instance.getParentType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParentType method, of class BaseEntity.
     */
    @Test
    public void testSetParentType() {
        System.out.println("setParentType");
        Class<? extends BaseEntity> parentType = null;
        BaseEntity instance = new BaseEntityImpl();
        instance.setParentType(parentType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParent method, of class BaseEntity.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        Entity parent = null;
        BaseEntity instance = new BaseEntityImpl();
        instance.setParent(parent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParent method, of class BaseEntity.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        BaseEntity instance = new BaseEntityImpl();
        Entity expResult = null;
        Entity result = instance.getParent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastModified method, of class BaseEntity.
     */
    @Test
    public void testGetLastModified() {
        System.out.println("getLastModified");
        BaseEntity instance = new BaseEntityImpl();
        Long expResult = null;
        Long result = instance.getLastModified();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntityClass method, of class BaseEntity.
     */
    @Test
    public void testGetEntityClass() {
        System.out.println("getEntityClass");
        BaseEntity instance = new BaseEntityImpl();
        String expResult = "";
        String result = instance.getEntityClass();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class BaseEntityImpl extends BaseEntity {

        @Override
        public Long getId() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setId(Long id) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
