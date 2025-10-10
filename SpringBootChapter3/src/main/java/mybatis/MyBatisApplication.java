package mybatis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mybatis.main.mapper.ArticleMapper;
import mybatis.main.mapper.MemberMapper;
import mybatis.main.model.Article;
import mybatis.main.model.Member;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MyBatisApplication implements ApplicationRunner {
    private final MemberMapper memberMapper;
    private final ArticleMapper articleMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        int count = memberMapper.selectAllCount();
        log.info("Member count: {}", count);

        Member member = memberMapper
                .selectByEmail("SeojunYoon@hanbit.co.kr")
                .orElseThrow();
        log.info("Member: {}", member);

        Article article = Article.builder()
                .title("Hello, MyBatis")
                .description("MyBatis is an SQL Mapper framework")
                .memberId(member.getId())
                .build();
        int inserted = articleMapper.insert(article);
        log.info("Inserted: {}", inserted);
    }
}