package api.hgseviceweb.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class DB_USER {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long  id;
    @Column(length=50,name="NAME")
    private String name;
    @Column(length=50,name="NAME_EN")
    private String nameEn;
    @Column(length=20,nullable=false)
    private String phone;
    @Column(length=20)
    private String phone1;
    @Column(length=100)
    private String email;
    @Column(nullable = false)
    private Boolean gender;
    @Column(nullable = false)
    private Boolean status;
    @Column(length=20,nullable=false)
    private String userCode;
    @Column(length=100,name="CREATED_BY",nullable = false)
    private String createdBy;
    @Column(name="CREATED_DATE",nullable = false )
    private Date createdDate;
    @Column(length=50,name="DB_CODE")
    private String dbCode;
     @Column(name="UPDATED_BY",nullable = true )
    private String updatedBy;
    @Column(name="UPDATED_DATE",nullable = true )
    private Date updatedDate;
}
