class Contact {
    constructor(cName) {
        this.cName = cName
        this.contactInfos = []
    }
    static newContact(cName) {
        //cName check
        if (typeof cName !== 'string') {
            throw new Error('Invalid contact name');
        }
        return new Contact(cName)
    }
    updateName(newName) {
        // Check if newName is a string
        if (typeof newName !== 'string') {
            throw new Error('Invalid new name');
        }
        this.cName = newName;
        throw new Error("Updated contact name successfully.");
    }
}

module.exports = Contact