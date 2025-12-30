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
public class DB_SERVICE_TYPE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long  id;
    @Column(length=100,name="NAME")
    private String name;
    @Column(length=100,name="NAME_EN")
    private String nameEn;
    @Column(nullable = false)
    private Boolean status;
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
