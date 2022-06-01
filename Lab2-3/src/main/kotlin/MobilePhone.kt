class MobilePhone(var myNumber: String){
    var myContacts: ArrayList<Contact> = arrayListOf()

    fun addNewContact(newContact: Contact): Boolean {
        if (myContacts.contains(newContact)) return false else myContacts.add(newContact)
        return true
    }

    fun updateContact(oldContact: Contact, newContact: Contact): Boolean{
        if (myContacts.contains(oldContact)){
            myContacts[myContacts.indexOf(oldContact)] = newContact
            return true
        }
        return false
    }

    fun removeContact(contact: Contact): Boolean{
        return myContacts.remove(contact)

    }

    fun findContact(contact: Contact): Int{
        return myContacts.indexOf(contact)
    }

    fun queryContact(contactName: String): Contact{
        for (contact in myContacts){
            if (contact.name == contactName) return contact
        }
        return Contact("", "")
    }

    fun printContacts(){
        myContacts.forEach{e -> println("Contact: ${e.name} - ${e.phoneNumber}")}
    }
}

data class Contact(var name: String, var phoneNumber: String){}