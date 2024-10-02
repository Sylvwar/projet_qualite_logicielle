package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {
    private static Configuration instance;
    private static Properties propConf = new Properties();
    private ClassLoader mockClassLoader;
    private InputStream mockInputStream;

    @BeforeEach
    public void setUp() {
        instance = new Configuration();
    }

    @Test
    public void testGetConfig() {
        propConf = null;
        assertNull(Configuration.getConfig("key"));
    }

}
