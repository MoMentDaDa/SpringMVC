package many2mang.Domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@SuppressWarnings("all")
public class Teacher {
    private Long id;
    private String name;
    private List<Student> stds = new ArrayList<>();
}