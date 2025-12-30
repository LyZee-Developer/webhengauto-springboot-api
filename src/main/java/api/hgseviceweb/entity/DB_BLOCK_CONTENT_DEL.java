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
public class DB_BLOCK_CONTENT_DEL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long  id;
    private Long blockContentId;
     @Column(nullable = false)
    private String title;
    private String titleEnglish;
    @Column(nullable = false)
    private String description;
    private String descriptionEnglish;
    @Column(nullable = false)
    private Boolean status;
    @Column(length=100,nullable = false)
    private String createdBy;
    @Column(nullable = false )
    private Date createdDate;
    @Column(length=50)
    private String dbCode;
     @Column(nullable = true )
    private String updatedBy;
    @Column(nullable = true )
    private Date updatedDate;
}
