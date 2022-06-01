import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MobilePhoneTest {

    val mobilePhone = MobilePhone("911")

    @Test
    fun addNewContact() {
        mobilePhone.addNewContact(Contact("Тестовый", "211"))
        assertTrue(mobilePhone.myContacts.component1().equals(Contact("Тестовый", "211")))
    }

    @Test
    fun updateContact() {
        mobilePhone.addNewContact(Contact("Тестовый", "211"))
        mobilePhone.updateContact(Contact("Тестовый", "211"), Contact("Test213123123", "88221"))
        assertTrue(mobilePhone.myContacts.component1().equals(Contact("Test213123123", "88221")))
    }

    @Test
    fun removeContact() {
        mobilePhone.addNewContact(Contact("Тестовый", "211"))
        mobilePhone.addNewContact(Contact("Тестовый2", "2113"))
        mobilePhone.removeContact(Contact("Тестовый", "211"))
        assertTrue(mobilePhone.myContacts.component1().equals(Contact("Тестовый2", "2113")))
    }

    @Test
    fun findContact() {
        val testContact = Contact("Тестовый", "211")
        mobilePhone.addNewContact(testContact)
        val index = mobilePhone.findContact(testContact)
        assertTrue(mobilePhone.myContacts[index].equals(testContact))
    }

    @Test
    fun queryContact() {
        val testContact = Contact("Тестовый", "211")
        mobilePhone.addNewContact(testContact)
        assertTrue(mobilePhone.queryContact("Тестовый").equals(testContact))
    }
}