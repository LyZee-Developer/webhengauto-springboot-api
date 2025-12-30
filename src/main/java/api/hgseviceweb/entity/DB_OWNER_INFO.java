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
public class DB_OWNER_INFO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=50,nullable=false)
    private String name;
    @Column(length=50,nullable=false)
    private String nameEn;
    @Column(length=15,nullable=false)
    private String phone;
    @Column(length=15,nullable=true)
    private String phone1;
    @Column(length=255)
    private String email;
    private String subDescription;
    private String subDescriptionEnglish;
    @Column(length=1000)
    private String description;
    @Column(length=1000)
    private String descriptionEnglish;
    private String facebookUrl;
    private String inUrl;
    private String instagramUrl;
    private String youtubeUrl;
    private String telegramUrl;
    private String workingInfo;
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
