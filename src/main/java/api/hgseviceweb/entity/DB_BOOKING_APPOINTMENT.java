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
public class DB_BOOKING_APPOINTMENT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(length=50)
    private String fullName;
    @Column(length=255)
    private String email;
    @Column(length=20,nullable=false)
    private String phone;
    @Column(length=20)
    private String phone1;
    @Column(nullable=false)
    private String serviceId;
    @Column(length=1000,nullable=false)
    private String problem;
    @Column(nullable=false)
    private Long carId;
    private String year;
    @Column(nullable = false)
    private Boolean isComplete;
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
