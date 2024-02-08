package shop.mtcoding.blog.board;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.blog._core.PagingUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Import(BoardRepository.class)
//엔티티 매니저랑 필요한 @import한 테이터만 만들어 준다.DB관련 어노테이션
@DataJpaTest
class BoardControllerTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void List() {
        int currentPage = 0;
        List<Integer> pageNumbers = PagingUtil.getPageNumbers(currentPage + 1, 5);
        System.out.println("pageNumbers = " + pageNumbers);


        for (int pageNumber : pageNumbers) {
            System.out.println("pageNumber = " + pageNumber);

        }
    }

    @Test
    public void pagingList() {
        int currentPage = 0;
        int totalCount = 21;
        int pagingCount = 5;
        int remainCount = totalCount % pagingCount;
        //3 % 3 = 0
        //5 % 3 = 1
        System.out.println("remainCount = " + remainCount);

        int totalPageCount = totalCount / pagingCount;
        // 3 / 3 = 1
        // 5 / 3 = 1

        if (remainCount > 0) {
            totalPageCount = totalPageCount + 1;
        }

        System.out.println("totalPageCount = " + totalPageCount);


        int remainPage = totalCount % pagingCount;
        //20 % 5 = 0

        int startPage = totalCount - (currentPage * pagingCount);

        // 5개의 게시물 번호 출력

        for (int i = startPage; i > startPage - pagingCount; i--) {
            System.out.println(i);
        }


        if (totalPageCount <= 5) {

        }
    }
}
