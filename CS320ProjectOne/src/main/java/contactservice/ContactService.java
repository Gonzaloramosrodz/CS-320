package contactservice;

/**
 * Author: Gonzalo Ramos
 * Course: CS 320
 * Project: Project One
 * Date: 4/11/2025
 */

import java.util.ArrayList;

public class ContactService {

    private ArrayList<Contact> contactList;

    public ContactService() {
        contactList = new ArrayList<>();
    }

    public void addContact(String id, String firstName, String lastName, String phone, String address) {
        if (getContactIndexById(id) != -1) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }

        Contact contact = new Contact(id, firstName, lastName, phone, address);
        contactList.add(contact);
    }

    public void deleteContact(String id) {
        int index = getContactIndexById(id);
        if (index == -1) {
            throw new IllegalArgumentException("Contact not found.");
        }

        contactList.remove(index);
    }

    public void updateFirstName(String id, String firstName) {
        int index = getContactIndexById(id);
        if (index == -1) {
            throw new IllegalArgumentException("Contact not found.");
        }

        contactList.get(index).setFirstName(firstName);
    }

    public void updateLastName(String id, String lastName) {
        int index = getContactIndexById(id);
        if (index == -1) {
            throw new IllegalArgumentException("Contact not found.");
        }

        contactList.get(index).setLastName(lastName);
    }

    public void updatePhone(String id, String phone) {
        int index = getContactIndexById(id);
        if (index == -1) {
            throw new IllegalArgumentException("Contact not found.");
        }

        contactList.get(index).setPhone(phone);
    }

    public void updateAddress(String id, String address) {
        int index = getContactIndexById(id);
        if (index == -1) {
            throw new IllegalArgumentException("Contact not found.");
        }

        contactList.get(index).setAddress(address);
    }

    public Contact getContact(String id) {
        int index = getContactIndexById(id);
        if (index == -1) {
            throw new IllegalArgumentException("Contact not found.");
        }
        return contactList.get(index);
    }

    private int getContactIndexById(String id) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getContactId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}