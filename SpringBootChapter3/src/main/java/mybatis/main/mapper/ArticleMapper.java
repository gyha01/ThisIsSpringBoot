package mybatis.main.mapper;

import mybatis.main.model.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ArticleMapper {
    @Results(id = "articleResult", value = {
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "content"),
            @Result(property = "memberId", column = "member_id")
    })
    @Select("select * from article")
    List<Article> selectAll();

    @Select("select count(*) from article")
    int selectAllCount();

    @Select("select * from article where id = #{id}")
    Optional<Article> selectById(@Param("id") Long id);

    @Select("select * from article where member_id = #{memberId}")
    List<Article> selectByMemberId(@Param("memberId") Long memberId);

    @Insert("insert into article(title, description, created, updated, member_id)" +
            " values (#{article.title}, #{article.description}, current_timestamp, current_timestamp, #{article.memberId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(@Param("article") Article article);

    @Update("""
            update article
            set title = #{title}, description = #{description}, updated = current_timestamp
            where id = #{id}
            """)
    int update(@Param("id") Long id, @Param("title") String title, @Param("description") String description);

    @Delete("delete article where id = #{id}")
    int deleteById(@Param("id") Long id);

    @Delete("delete article where number_id = #{number_id}")
    int deleteByMemberId(@Param("memberId") Long memberId);

    @Delete("delete article")
    int deleteAll();
}
