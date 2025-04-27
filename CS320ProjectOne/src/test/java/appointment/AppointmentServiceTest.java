package appointment;

/**
 * Author: Gonzalo Ramos
 * Course: CS 320
 * Project: Project One
 * Date: 4/11/2025
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    private AppointmentService service;
    private Appointment appointment;

    @BeforeEach
    void setUp() {
        service = new AppointmentService();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date futureDate = cal.getTime();
        appointment = new Appointment("ID001", futureDate, "Checkup");
    }

    @Test
    void testAddAppointment() {
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointment("ID001"));
    }

    @Test
    void testAddDuplicateAppointment() {
        service.addAppointment(appointment);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appointment);
        });
    }

    @Test
    void testDeleteAppointment() {
        service.addAppointment(appointment);
        service.deleteAppointment("ID001");
        assertNull(service.getAppointment("ID001"));
    }

    @Test
    void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("NON_EXISTENT_ID");
        });
    }
}
