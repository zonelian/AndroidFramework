package com.zonelian.framework.base.okhttp;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

/**
 * Created by kernel on 16/6/28.
 * Email: 372786297@qq.com
 */
public class UrlBuilderTest extends TestCase{
    private String result = "www.baidu.com?name=artist&sex=male&age=26";

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testbuild() throws Exception {
        UrlBuilder urlBuilder = new UrlBuilder();
        urlBuilder.setUrl("www.baidu.com");
        urlBuilder.addParam("name", "artist").addParam("sex", "male").addParam("age", "26");
        Assert.assertEquals(result, urlBuilder.build());
    }
}
