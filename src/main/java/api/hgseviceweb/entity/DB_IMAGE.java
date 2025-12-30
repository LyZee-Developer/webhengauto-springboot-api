package api.hgseviceweb.entity;

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
public class DB_IMAGE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
     @Column(nullable=false)
    private Long refId;
     @Column(nullable=false)
    private String type;
     @Column(nullable=false)
    private String pathImage;
    private String hostImage;
    @Column(nullable=false)
    private String typeImage;
     @Column(nullable=false)
    private Long sizeImage;
     @Column(nullable=false)
    private String nameImage;

}
