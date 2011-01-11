package org.apache.maven.surefire.junitcore;

import org.apache.maven.surefire.report.MulticastingReporter;

import java.util.Collections;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.Computer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import static junit.framework.Assert.assertEquals;

/**
 * @author Kristian Rosenvold
 */
public class JUnitCoreRunListenerTest
{
    @Test
    public void testTestRunStarted()
        throws Exception
    {
        RunListener jUnit4TestSetReporter = new JUnitCoreRunListener( new MulticastingReporter( Collections.emptyList() ),
                                                                      new HashMap<String, TestSet>(  ) );
        JUnitCore core = new JUnitCore();
        core.addListener(  jUnit4TestSetReporter );
        Result result = core.run( new Computer(), STest1.class, STest2.class);
        core.removeListener(  jUnit4TestSetReporter );
        assertEquals(2, result.getRunCount());
    }


    public static class STest1
    {
        @Test
        public void testSomething(){

        }
    }
    public static class STest2
    {
        @Test
        public void testSomething2(){

        }
    }
}
