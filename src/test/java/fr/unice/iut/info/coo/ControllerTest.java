package fr.unice.iut.info.coo;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by Thomas on 25/10/2016.
 */
public class ControllerTest extends TestCase {

    private BusManager manager = new BusManager();
    private UI affichage = new UI();


    @Before
    public void initiate () {
        
    }

    @Test
    public void start() throws Exception {
        manager.createBus("Test");
        manager.createBox("Test", "TestB");
        manager.emitIntoBox("Test", "TestB", "TestM");
        assertEquals(((ArrayList<String>)manager.getAllBusNames()).indexOf("Test"), 0);
    }

}