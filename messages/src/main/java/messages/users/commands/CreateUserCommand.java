package messages.users.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class CreateUserCommand {
    @TargetAggregateIdentifier
    private final String userId;
    private final String userName;
    private final String password;
    private final String firstName;
    private final String lastName;

    public CreateUserCommand(String userName, String password, String firstName, String lastName) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
