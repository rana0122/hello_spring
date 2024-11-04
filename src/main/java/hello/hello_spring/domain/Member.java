package hello.hello_spring.domain;

import jakarta.persistence.*;

@Entity
public class Member {
//    org.springframework.data.annotation.Id가 아니라 jakarta.persistence.Id를 사용해야 합니다.
//    @Id와 @GeneratedValue는 JPA 엔티티에서 기본 키 생성을 위해 사용되며, jakarta.persistence 패키지에서 가져와야 합니다.
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
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
