package net.proselyte.gofpatterns.behavioral.mediator;

public class SimpleChatRunner {
    public static void main(String[] args) {
        SimpleTextChat chat = new SimpleTextChat();
        User admin = new Admin(chat,"Admin");
        User u1 = new SimpleUser(chat,"User1");
        User u2 = new SimpleUser(chat,"User2");

        chat.setAdmin(admin);
        chat.addUserToChat(u1);
        chat.addUserToChat(u2);

        u1.sendMessage("Hello i am user one!!! ");
        admin.sendMessage("Huston, I am admin");
    }
}
