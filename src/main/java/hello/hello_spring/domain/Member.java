package hello.hello_spring.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Member {

    @jakarta.persistence.Id
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;
    private String name;


    //getter,setter import -> generate:  alt+insert
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
