package hello.hello_spring.domain;

public class Member {

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
