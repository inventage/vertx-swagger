package io.vertx.ext.swagger.codegen;

import org.junit.Assert;
import org.junit.Test;

public class JavaVertServerGeneratorToTest extends JavaVertXServerGenerator {

    @Test
    public void testExtractPortFromNullHost() {
        String result = this.extractPortFromHost(null);
        Assert.assertEquals("8080", result);
    }
    
    @Test
    public void testExtractPortFromHostWithoutPort() {
        String result = this.extractPortFromHost("myserver");
        Assert.assertEquals("8080", result);
    }
    
    @Test
    public void testExtractPortFromHostWithSemicolonWithoutPort() {
        String result = this.extractPortFromHost("myserver:");
        Assert.assertEquals("8080", result);
    }
    
    @Test
    public void testExtractPortFromHostWithPort() {
        String result = this.extractPortFromHost("myserver:1111");
        Assert.assertEquals("1111", result);
    }
}
