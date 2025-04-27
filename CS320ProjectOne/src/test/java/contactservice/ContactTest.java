package contactservice;

/**
 * Author: Gonzalo Ramos
 * Course: CS 320
 * Project: Project One
 * Date: 4/11/2025
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void testValidContact() {
        Contact c = new Contact("C100", "Gonzalo", "Ramos", "1234567890", "42 Tesla Blvd");
        assertEquals("C100", c.getContactId());
        assertEquals("Gonzalo", c.getFirstName());
        assertEquals("Ramos", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("42 Tesla Blvd", c.getAddress());
    }

    @Test
    void testSettersWork() {
        Contact c = new Contact("C101", "Alex", "Smith", "9876543210", "55 SpaceX Ave");
        c.setFirstName("Leo");
        c.setLastName("Garcia");
        c.setPhone("1112223333");
        c.setAddress("91 Mars Way");
        assertEquals("Leo", c.getFirstName());
        assertEquals("Garcia", c.getLastName());
        assertEquals("1112223333", c.getPhone());
        assertEquals("91 Mars Way", c.getAddress());
    }

    @Test
    void testInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Ana", "Lee", "1234567890", "17 Oak St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("THISIDISWAYTOOLONG", "Ana", "Lee", "1234567890", "17 Oak St");
        });
    }

    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C102", "Ben", "Wong", "12345", "Park Dr");
        });
    }
}