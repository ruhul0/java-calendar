package edu.avans.library.presentation;
import edu.avans.library.domain.CCalendar;
import javax.swing.*;

/**
 * The <code>CalendarPanel</code> ensures the panel in which the calendar user-interface will be placed.
 * It is placed within <code>MainPanel</code>.
 * @author Bram de Hart
 * @version 1.0
 * @see MainPanel
 */
public class CalendarPanel extends JPanel {
    private Integer calendarPanelWidth, calendarPanelHeight;
    private MainFrame mainFrame; // for now private
    public MainPanel mainPanel;
    public MonthPanel monthPanel;
    public CCalendar calendar;

    /**
     * Constructor. Creates an calendar object and inits the calendar-panel.
     * @param mainPanel is passed to have access to it's methods.
     */
    public CalendarPanel(MainPanel mainPanel) {
        mainFrame = mainPanel.mainFrame;
        this.mainPanel = mainPanel;
        setCalendarPanelDimensions();
        initCalendarPanel();
    }

    /**
     * Inits the calendar-panel.
     */
    private void initCalendarPanel() {
        setLayout(null);
        setCalendarPanelBounds();
        drawMonthPanel();
    }

    /**
     * Resizes the panels. Is called by an <code>resizeListener</code> inside <code>MainPanel</code>.
     */
    public void resizeCalendarPanel() {
        setCalendarPanelDimensions();
        setCalendarPanelBounds();
        monthPanel.resizeMonthPanel();
    }

    /**
     * Sets the calendar-panel's dimensions.
     */
    private void setCalendarPanelDimensions() {
        calendarPanelWidth = mainFrame.getMainFrameWidth();
        calendarPanelHeight = mainFrame.getMainFrameHeight() - mainPanel.getTopPanelHeight();
    }

    /**
     * Sets the calendar-panel's bounds with the known dimensions.
     */
    private void setCalendarPanelBounds() {
        setBounds(0, mainPanel.getTopPanelHeight(), calendarPanelWidth, calendarPanelHeight);
    }

    /**
     * Gets the width of the calendar-panel.
     * @return the width of the calendar-panel
     */
    public Integer getCalendarPanelWidth() {
        return calendarPanelWidth;
    }

    /**
     * Gets the height of the calendar panel.
     * @return the height of the calendar panel
     */
    public Integer getCalendarPanelHeight() {
        return calendarPanelHeight;
    }

    /**
     * Draws the month-panel.
     */
    public void drawMonthPanel() {
        monthPanel = new MonthPanel(CalendarPanel.this);
        add(monthPanel);
    }
}
