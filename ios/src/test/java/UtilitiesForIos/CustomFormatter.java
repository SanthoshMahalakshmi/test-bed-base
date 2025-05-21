package UtilitiesForIos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    @Override
    public String format(LogRecord record) {
        String time = sdf.format(new Date(record.getMillis()));
        String level = String.format("%-5s", record.getLevel()); // Pads to align
        return String.format("[%s] %s - %s%n", time, level, record.getMessage());
    }
}

