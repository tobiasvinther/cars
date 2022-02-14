package kea.sem3.jwtdemo.entity;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@DiscriminatorValue("MEMBER")
public class Member extends BaseUser {

    String firstName;
    @OneToMany(mappedBy = "reservingMember") //the reservations this member has
    private List<Reservation> reservations = new ArrayList<>();

    public Member(String username, String email, String password, String firstName) {
        super(username, email, password);
        this.firstName = firstName;
    }

    public Member() {
    }
}
