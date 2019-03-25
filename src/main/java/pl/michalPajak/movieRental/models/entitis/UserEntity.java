package pl.michalPajak.movieRental.models.entitis;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "user_name")
    private String userName;
    private String password;
    private String email;
    @Column(name = "is_admin")
    private int admin;

    @OneToMany(mappedBy = "user")
    List<CommentEntity> commentList;

    public boolean isAdmin() {
        return admin > 0 ? true : false;
    }
}
