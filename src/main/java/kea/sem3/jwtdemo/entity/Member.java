package kea.sem3.jwtdemo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MEMBER")
public class Member extends BaseUser {

    String firstName;

    public Member(String username, String email, String password, String firstName) {
        super(username, email, password);
        this.firstName = firstName;
    }

    public Member() {
    }
}
