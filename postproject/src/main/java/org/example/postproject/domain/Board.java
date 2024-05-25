package org.example.postproject.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Board {
    @Id
    private Long id;
    private String name;
    private String title;
    private String password;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Board(String name, String title, String password) {
        this.name = name;
        this.title = title;
        this.password = password;
    }


}
