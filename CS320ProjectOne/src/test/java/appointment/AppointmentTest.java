package appointment;

/**
 * Author: Gonzalo Ramos
 * Course: CS 320
 * Project: Project One
 * Date: 4/11/2025
 */

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    void testValidAppointment() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date futureDate = cal.getTime();
        Appointment appointment = new Appointment("1234567890", futureDate, "Doctor visit");
        assertEquals("1234567890", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor visit", appointment.getDescription());
    }

    @Test
    void testInvalidAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Description");
        });
    }

    @Test
    void testInvalidDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", pastDate, "Description");
        });
    }

    @Test
    void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", futureDate, null);
        });
    }
}
