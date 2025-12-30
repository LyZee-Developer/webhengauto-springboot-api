package api.hgseviceweb.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class DB_AUTH_ACCESS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=1,nullable = false)
    private String type; //A(Admin) || O(Other)
    private Long userId;
    @Column(length=30,nullable = false,unique = true)
    private String username;
    @Column(length=500,nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean status;
    @Column(length=100,name="CREATED_BY",nullable = false)
    private String createdBy;
    @Column(name="CREATED_DATE",nullable = false )
    private Date createdDate;
    @Column(length=50,name="DB_CODE",nullable = false)
    private String dbCode;
     @Column(name="UPDATED_BY",nullable = true )
    private String updatedBy;
    @Column(name="UPDATED_DATE",nullable = true )
    private Date updatedDate;

}
