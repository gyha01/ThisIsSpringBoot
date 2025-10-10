package mybatis.main.mapper;

import mybatis.main.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    List<Member> selectAll();
    Optional<Member> selectById(@Param("id") Long id);
    Optional<Member> selectByEmail(@Param("email") String email);
    List<Member> selectAllOrderByAgeAsc();
    List<Member> selectAllOrderBy(@Param("order")String order, @Param("dir") String dir);
    List<Member> selectByNameLike(@Param("name") String name);

    int selectAllCount();
    int insert(@Param("member") Member member);
    int update(@Param("member") Member member);
    int delete(@Param("member") Member member);
    int deleteAll();
}
