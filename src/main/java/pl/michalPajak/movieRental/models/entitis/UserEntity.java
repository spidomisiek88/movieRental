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

    @OneToMany(mappedBy = "user")
    List<CommentEntity> commentList;
}
