package budgee;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

public class Analytics extends JPanel {

    private JCalendar calendar;
    private JDayChooser dayChooser;
    private Map<String, String> notesMap;

    public Analytics() {
        setLayout(null);

        createCalendarPanel();

        notesMap = new HashMap<>();
        updateNotesLabels();
    }

    private void createCalendarPanel() {
        calendar = new JCalendar();
        calendar.setBounds(10, 11, 434, 268);
        dayChooser = calendar.getDayChooser();
        add(calendar);

        dayChooser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    // Retrieve the selected date
                    Date selectedDate = new Date(calendar.getDate().getTime());
                    Calendar selectedCalendar = Calendar.getInstance();
                    selectedCalendar.setTime(selectedDate);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String dateString = dateFormat.format(selectedCalendar.getTime());

                    // Prompt the user for a note
                    String note = JOptionPane.showInputDialog(Analytics.this, "Enter a note:");

                    // Store the note in the notes map
                    if (note != null) {
                        notesMap.put(dateString, note);
                        updateNotesLabels();
                    }
                }
            }
        });
    }

    // Update the notes labels on the JCalendar
    private void updateNotesLabels() {
        dayChooser.getDayPanel().removeAll();

        for (Map.Entry<String, String> entry : notesMap.entrySet()) {
            String dateString = entry.getKey();
            String note = entry.getValue();

            JLabel noteLabel = new JLabel(note);
            noteLabel.setForeground(Color.BLUE);

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                calendar.setTime(dateFormat.parse(dateString));
                dayChooser.getDayPanel().add(noteLabel, calendar.get(Calendar.DAY_OF_MONTH) - 1);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        dayChooser.getDayPanel().revalidate();
        dayChooser.getDayPanel().repaint();
    }
}
