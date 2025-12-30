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
public class DB_BLOCK_CONTENT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
     @Column(nullable = false)
    private String title;
    private String titleEnglish;
    private String subTitle;
    private String subTitleEnglish;
    private String description;
    private String descriptionEnglish;
    @Column(nullable = false)
    private String type;
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
