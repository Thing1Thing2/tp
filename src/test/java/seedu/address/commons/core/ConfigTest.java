package seedu.address.commons.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.logging.Level;

import org.junit.jupiter.api.Test;

public class ConfigTest {

    @Test
    public void toString_defaultObject_stringReturned() {
        String defaultConfigAsString = "Current log level : INFO\n"
                + "Preference file Location : preferences.json";

        assertEquals(defaultConfigAsString, new Config().toString());
    }

    @Test
    public void equalsMethod() {
        Config defaultConfig = new Config();
        assertNotNull(defaultConfig);
        assertTrue(defaultConfig.equals(defaultConfig));
    }

    @Test
    public void getLogLevelTest_defaultConfig_returnsCorrectLogLevel() {
        Config defaultConfig = new Config();
        assertTrue(defaultConfig.getLogLevel().equals(Level.INFO));

        defaultConfig.setLogLevel(Level.CONFIG);
        assertTrue(defaultConfig.getLogLevel().equals(Level.CONFIG));
    }

    @Test
    public void getUserPrefFilePath_defaultConfig_returnsCorrectPath() {
        Config defaultConfig = new Config();
        assertTrue(defaultConfig.getUserPrefsFilePath() instanceof Path);
        assertTrue(defaultConfig.getUserPrefsFilePath().equals(Paths.get("preferences.json")));
    }

    @Test
    public void hashCode_defaultConfig_correctHashCalculate() {
        Config defaultConfig = new Config();
        int calculatedHash = Objects.hash(defaultConfig.getLogLevel(), defaultConfig.getUserPrefsFilePath());
        assertEquals(calculatedHash, defaultConfig.hashCode());
    }


}
