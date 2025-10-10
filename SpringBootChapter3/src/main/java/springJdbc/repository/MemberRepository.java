package springJdbc.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springJdbc.Member;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    // 기본적인 CRUD 메서드(save, findById, findAll, deleteById) 제공

    // 이름 검색 & 이메일 검색
    List<Member> findByName(String name);
    List<Member> findByEmail(String email);

    // 이름 포함 여부
    List<Member> findByNameContaining(String name);

    // 이름과 이메일 모두 만족하는 조건 검색 메서드
    List<Member> findByNameAndEmail(String name, String email);

    // 이름 또는 이메일 중 하나만 만족하는 멤버 검색 메서드
    List<Member> findByNameOrEmail(String name, String email);

    // 나이 범위 내에 속하는 멤버를 조회하는 메서드
    List<Member> findByAgeGreaterThan(int age);
    List<Member> findByAgeLessThan(int age);
    List<Member> findByAgeBetween(int min, int max);

    // Query로 직접 작성
    // 13세 이상 19세 미만 멤버를 검색하는 메서드
    @Query("select * from member where age >= 13 and age <= 19")
    List<Member> findTeenAge();

    // 입력한 최소값과 최대값 사이의 나이를 지닌 멤버를 검색하는 메서드
    @Query("select * from member where age >= :min and age <= :max")
    List<Member> findByAgeRange(int min, int max);
}
