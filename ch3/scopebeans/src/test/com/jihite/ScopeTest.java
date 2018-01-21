package com.jihite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class ScopeTest {
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes=ComponentConfig.class)
    public static class ComponentScanScopeBeanTest {
        @Autowired
        private UniqueThing uniqueThing1;

        @Autowired
        private UniqueThing uniqueThing2;

        @Autowired
        private PrototypeThing prototypeThing1;

        @Autowired
        private PrototypeThing prototypeThing2;

        @Test
        public void testProxyScopy() {
            assertNotSame(prototypeThing1, prototypeThing2);
        }

        @Test
        public void testSingle() {
            assertSame(uniqueThing1, uniqueThing2);
        }
    }
}
