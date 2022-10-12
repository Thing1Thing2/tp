package seedu.address.commons.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Point;

import org.junit.jupiter.api.Test;


public class GuiSettingsTest {
    private static final double DEFAULT_HEIGHT = 600;
    private static final double DEFAULT_WIDTH = 740;

    @Test
    public void getWindowWidth_variousGuiSettings_returnsCorrectWidth() {
        // default width
        GuiSettings gs = new GuiSettings();
        assertEquals(gs.getWindowWidth(), DEFAULT_WIDTH);

        // customised width
        int newWidth = -1;
        gs = new GuiSettings(newWidth, 100, 0, 0);
        assertEquals(gs.getWindowWidth(), newWidth);
    }

    @Test
    public void getWindowHeight_variousGuiSettings_returnsCorrectHeight() {
        // default height
        GuiSettings gs = new GuiSettings();
        assertEquals(gs.getWindowHeight(), DEFAULT_HEIGHT);

        // customised height
        int newHeight = -1;
        gs = new GuiSettings(100, newHeight, 0, 0);
        assertEquals(gs.getWindowHeight(), newHeight);
    }

    @Test
    public void getWindowCoordinates_variousGuiSettings_returnsCorrectPoint() {
        // default coordinates i.e. null
        GuiSettings gs = new GuiSettings();
        assertNull(gs.getWindowCoordinates());

        // customised valid coordinate
        int newX = 100;
        int newY = 100;
        gs = new GuiSettings(DEFAULT_WIDTH, DEFAULT_WIDTH, newX, newY);
        assertEquals(new Point(newX, newY), gs.getWindowCoordinates());

        // negative coordinate
        gs = new GuiSettings(DEFAULT_WIDTH, DEFAULT_HEIGHT, -newX, -newY);
        assertEquals(new Point(-newX, -newY), gs.getWindowCoordinates());
    }

    @Test
    public void equals_variousGuiSettings() {
        // same GuiSettings object -> true
        GuiSettings gs = new GuiSettings();
        assertTrue(gs.equals(gs));

        // random object -> false
        Object o = new Object();
        assertFalse(gs.equals(o));

        // different objects with same height, width, and coordinate -> true
        int height = 100;
        int width = 100;
        int x = 0;
        int y = 0;
        GuiSettings gs1 = new GuiSettings(height, width, x, y);
        GuiSettings gs2 = new GuiSettings(height, width, x, y);
        assertTrue(gs1.equals(gs2));
        assertTrue(gs2.equals(gs1));
    }

}
