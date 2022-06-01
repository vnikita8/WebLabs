fun main(args: Array<String>) {
    val myPhone = MobilePhone("80000000000")
    println("Add contact (Test1, 321) = " + myPhone.addNewContact(Contact("Test1", "321")))
    println("Add contact (Test2, 123) = " + myPhone.addNewContact(Contact("Test2", "123")))

    println("\nUpdate contact (Test1, 321) on (Test3, 555) = " + myPhone.updateContact(Contact("Test2", "123"), Contact("Test3", "555")))
    println("\nRemove contact (Test3, 555) = " + myPhone.removeContact(Contact("Test3", "555")))

    println("\nFind contact (Test3, 555) = " + myPhone.findContact(Contact("Test3", "555")))
    println("Find contact (Test1, 321) = " + myPhone.findContact(Contact("Test1", "321")))
    println("\nAdd contact (Test2, 123) = " + myPhone.addNewContact(Contact("Test2", "123")))
    println("Add contact (Test3, 555) = " + myPhone.addNewContact(Contact("Test3", "555")))
    println("\nPrintContacts:")
    myPhone.printContacts()

}

