//Driver Code

const User = require("./user");
const Contact = require("./contact");
const ContactInfo = require("./contactInfo");

try {
    const admin1 = User.newAdmin("yash", "yash1234");
    console.log("admin1>>>", admin1);
    const user1 = admin1.newUser("Ravi", "ravi1234");
    console.log("user1>>>", user1);
    const user2 = admin1.newUser("Abhay", "abhay1234");
    console.log("user2>>>", user2);
   

    user1.newContact("shubham bhamare");
    user1.newContact("Rushi wagh");
    user2.newContact("Pavan Nikam");
    user2.newContact("Pranit Sahane");
    console.log("user1.contacts>>>", user1.contacts);
    console.log("user2.contacts>>>", user2.contacts);
    user1.updateContact("Rushi Wagh", "name", "Mayur Ajurkar");
    
} catch (error) {
    console.log(error.message)
}
