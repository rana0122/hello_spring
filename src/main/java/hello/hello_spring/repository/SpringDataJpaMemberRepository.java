package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//JpaRepository interface를 interface로 받으므로  extends.
//interface는 다중상속 가능하므로 MemberRepository도 상속한다.
//springdata 를 사용하면 bean에서 자동으로 인터페이스가 있는걸 감지하여 구현체를 만들어줌.
//사용자는 구현체를 따로 만들 필요 없이 자동생성된 것을 그대로 가져다 쓰면 됨.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPSQL select m from Member m where m.name=?
    //만약 id와 name으로 조회해서 가져오고 싶다면 메소드 이름 명명규칙에 따라 선언하면 알아서  SQL이 생성된다.
    // ex) findByNameAndId(String name, Long id) :select m from Member m where m.name=? and m.id =?
    //Querydsl라는 라이브러리를 사용하면 동적쿼리도 작성 가능함.
    //이 조합으로 해결하기 어려운 쿼리는 JPA가 제공하는 네이티브 쿼리나, 스프링 JdbcTemplate을 사용하여 해결함.
    @Override
    Optional<Member> findByName(String name);
}
