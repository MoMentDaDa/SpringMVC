package many2mang.Domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@SuppressWarnings("all")
public class Student {
    private long id;
    private String name;
    private List<Teacher> teachers = new ArrayList<>();

}
