package pl.michalPajak.movieRental.models.entitis;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
//    @JsonIgnore
    private String password;
    private String email;
    @Column(name = "is_admin")
    private int admin;
    @Column(name = "is_delete")
    private int isDelete;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<CommentEntity> commentList;

    public boolean isAdmin() {
        return admin > 0 ? true : false;
    }
    public boolean isDelete() {
        return isDelete > 0 ? true : false;
    }
}
