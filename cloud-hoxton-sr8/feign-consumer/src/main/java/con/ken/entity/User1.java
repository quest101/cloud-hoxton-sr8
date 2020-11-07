package con.ken.entity;

import lombok.Data;


@Data
public class User1 {
    private String name;
    private Integer age;

    public User1(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
