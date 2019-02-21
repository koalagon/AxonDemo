package com.example.users.domain;

import messages.users.commands.CreateUserCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class UserAggregate {
    @Id
    @AggregateIdentifier
    private String id;
    private String userName;
    private String passwordHash;
    private String passwordSalt;
    private String firstName;
    private String lastName;

    @CommandHandler
    public UserAggregate(CreateUserCommand command) {
        this.id = command.getUserId();
        this.userName = command.getUserName();
        this.passwordSalt = UUID.randomUUID().toString();
        this.passwordHash = command.getPassword() + passwordSalt;
        this.firstName = command.getFirstName();
        this.lastName = command.getLastName();
    }
    protected UserAggregate() { }
}
