package com.acarasiov.vmsoft;

import com.acarasiov.vmsoft.dao.VendingMachineDao;
import com.acarasiov.vmsoft.dao.VendingMachineDaoInMemImpl;
import com.acarasiov.vmsoft.model.Change;
import com.acarasiov.vmsoft.model.Item;
import com.acarasiov.vmsoft.service.VendingMachineService;
import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineServiceImplTest {
    VendingMachineDaoInMemImpl dao;
    VendingMachineService service;
    private BigDecimal balance;
    private int itemChoice;
    private Change change;
    private String textMessage;

    public VendingMachineServiceImplTest() {
        this.dao = dao;
        balance = new BigDecimal ("0.00");
        itemChoice = 0;
        change = null;
        textMessage = null;
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        service = ctx.getBean("vendingMachineService", VendingMachineService.class);
    }

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

    @Test
    public void testAllItems() throws IOException {
        VendingMachineDao something = new VendingMachineDaoInMemImpl();
        List<Item> result = something.getAllItems();
        int length = result.size();
        assertEquals(9, length);
    }

    @Test
    public void testGetItemById() throws IOException {
        VendingMachineDao something = new VendingMachineDaoInMemImpl();
        Item currentItem = something.getItemById(2);
        assertTrue(currentItem != null);
    }
}
