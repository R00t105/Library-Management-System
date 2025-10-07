package restapiprojects.librarymanagementsystem.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String nationality;

    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;



    @Builder.Default
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Book> books = new ArrayList<>();


}
