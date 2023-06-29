//Driver Code

const User = require("./user");

try {
    const admin1 = User.newAdmin("pavan", "pavan1234")
    const user1 = admin1.newUser("shubh", "shubh1234")
    const user2 = admin1.newUser("rushi", "rushi1234")

    admin1.deleteUser("rushi1234");

    const contact1 = user1.newContact("pranit");
    const contact2 = user1.newContact("mayur");

    
    user1.updateContact("pranit","vishwa");
    user1.deleteContact("vishwa");
    
    user1.getContact("vishwa").newContactInfo("Home", 1111111111);
    user1.getContact("vishwa").newContactInfo("Personal", 2222222222);
    user1.getContact("vishwa").updateContactInfo("Home", 33333333333);
    console.log(user1.getContact("vishwa").getAllContactInfo());
    user1.getContact("vishwa").deleteContactInfo("Home");
    console.log(user1.getContact("vishwa").getAllContactInfo());

    console.log(user1.getContact("pavan").getAllContactInfo());
    console.log(contact2.newContactInfo("Home", 1111111111));

    admin1.updateUser("pavan1234", "name", "ravi")
    user1.newContact("shubh")
} catch (error) {
    console.log(error.message)
}

