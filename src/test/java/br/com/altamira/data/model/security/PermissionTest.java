/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.security;

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
public class PermissionTest {
    
    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "MaterialTest.war")
                .addClasses(Permission.class)
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
     * Test of getResourceName method, of class Permission.
     */
    @Test
    public void testGetResourceName() {
        System.out.println("getResourceName");
        Permission instance = new Permission();
        String expResult = "";
        String result = instance.getResourceName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResourceName method, of class Permission.
     */
    @Test
    public void testSetResourceName() {
        System.out.println("setResourceName");
        String resourceName = "";
        Permission instance = new Permission();
        instance.setResourceName(resourceName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPermission method, of class Permission.
     */
    @Test
    public void testGetPermission() {
        System.out.println("getPermission");
        Permission instance = new Permission();
        String expResult = "";
        String result = instance.getPermission();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPermission method, of class Permission.
     */
    @Test
    public void testSetPermission() {
        System.out.println("setPermission");
        String permission = "";
        Permission instance = new Permission();
        instance.setPermission(permission);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProfiles method, of class Permission.
     */
    @Test
    public void testGetProfiles() {
        System.out.println("getProfiles");
        Permission instance = new Permission();
        List<Profile> expResult = null;
        List<Profile> result = instance.getProfiles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProfiles method, of class Permission.
     */
    @Test
    public void testSetProfiles() {
        System.out.println("setProfiles");
        List<Profile> profiles = null;
        Permission instance = new Permission();
        instance.setProfiles(profiles);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
