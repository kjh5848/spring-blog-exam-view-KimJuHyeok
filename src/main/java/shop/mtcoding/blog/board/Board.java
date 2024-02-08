package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "board_tb")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String author;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 20, nullable = false)
    private String content;


}
