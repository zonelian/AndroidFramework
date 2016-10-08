package com.zonelian.framework.base;

import com.zonelian.framework.base.okhttp.OkResponseCallbackWrapperTest;
import com.zonelian.framework.base.okhttp.UrlBuilderTest;

import junit.framework.TestSuite;
import junit.framework.Test;
import junit.textui.TestRunner;

/**
 * Created by kernel on 16/6/27.
 * Email: 372786297@qq.com
 */
public class BaseModuleTestSuite extends TestSuite{

    public static Test suite() {
        TestSuite suite = new TestSuite("BaseModuleTest suite");
        suite.addTestSuite(OkResponseCallbackWrapperTest.class);
        suite.addTestSuite(UrlBuilderTest.class);
        return suite;
    }

    public static void main(String args[]) {
        TestRunner.run(suite());
    }
}
