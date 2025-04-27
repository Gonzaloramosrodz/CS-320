package contactservice;

/**
 * Author: Gonzalo Ramos
 * Course: CS 320
 * Project: Project One
 * Date: 4/11/2025
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    ContactService service;

    @BeforeEach
    void setup() {
        service = new ContactService();
    }

    @Test
    void testAddContact() {
        service.addContact("A101", "Nina", "Brown", "2223334444", "10 Maple Rd");
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact("A101", "Nick", "Black", "9998887777", "Wrong Address");
        });
    }

    @Test
    void testDeleteContact() {
        service.addContact("B202", "Jake", "Long", "3334445555", "99 King St");
        service.deleteContact("B202");
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("B202");
        });
    }

    @Test
    void testUpdateFields() {
        service.addContact("C303", "Lily", "Wren", "0001112222", "Beach House");
        service.updateFirstName("C303", "Lillian");
        service.updateLastName("C303", "Grant");
        service.updatePhone("C303", "4445556666");
        service.updateAddress("C303", "Sunset Strip");

        Contact c = service.getContact("C303");
        assertEquals("Lillian", c.getFirstName());
        assertEquals("Grant", c.getLastName());
        assertEquals("4445556666", c.getPhone());
        assertEquals("Sunset Strip", c.getAddress());
    }

    @Test
    void testUpdateInvalidContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("Z999", "0000000000");
        });
    }
}