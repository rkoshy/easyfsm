package io.github.ankzz.easyfsm.tests;

import io.github.ankzz.easyfsm.action.FSMAction;
import io.github.ankzz.easyfsm.fsm.FSM;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FSMTest {
    Logger logger = Logger.getLogger(FSMTest.class.getName());

    @Test
    public void testFSM() {
        try {
            FSM<Properties> f = new FSM<Properties>("", new FSMAction<Properties>() {
                @Override
                public boolean action(String curState, String message, Properties eventData, String nextState, Object args) {
                    logger.info(curState + ":" + message + " : " + nextState);
                    return true;
                }
            });
            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVELEFT");
            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVE");
            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVERIGHT");
            System.out.println(f.getCurrentState());
        } catch (ParserConfigurationException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            logger.log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testFSMWithData() {
        try {
            FSM<Properties> f = new FSM<Properties>("", new FSMAction<Properties>() {
                @Override
                public boolean action(String curState, String message, Properties eventData, String nextState, Object args) {
                    logger.info(curState + ":" + message + " : " + nextState);
                    return true;
                }
            });

            Properties eventData = new Properties();

            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVELEFT", eventData);
            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVE", eventData);
            System.out.println(f.getCurrentState());
            f.ProcessFSM("MOVERIGHT", eventData);
            System.out.println(f.getCurrentState());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FSMTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(FSMTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FSMTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}