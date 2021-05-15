package uz.pdp.pcmarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Comment {
    @Id
    @GeneratedValue
    private Integer id;
    private String message;
    private Date date;
    @ManyToOne
    private Users custom;
    private double mark;
    @ManyToOne
    private Product product;
}

