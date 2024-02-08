package shop.mtcoding.blog._core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PagingUtilTest {
    @Test
    void getPageNumbers() {
    // 테스트 데이터
    int currentPage = 3;
    int totalPageCount = 20;

    // 페이징 번호 목록
    List<Integer> pageNumbers = PagingUtil.getPageNumbers(currentPage, totalPageCount);

    // 예상 결과
    List<Integer> expectedPageNumbers = Arrays.asList(1, -1, 2, 3, 4, 5, 6, -1, 10);

    // 검증
    assertEquals(expectedPageNumbers, pageNumbers);
    }


    @Test
    void getPageNumber() {
        int currentPage = 0;
        int totalPageCount = 20;

        // 페이징 번호 목록을 담을 리스트 생성
        List<Integer> pageNumbers = new ArrayList<>();

        // 총 페이지 수가 5개 이하이면 모든 페이지 번호 추가
        if (totalPageCount <= 5) {
            for (int i = 1; i <= totalPageCount; i++) {
                pageNumbers.add(i);
            }
        }

        // 현재 페이지를 기준으로 이전/다음 페이지 2개씩 표시
        int startPage = Math.max(1, currentPage - 2);
        int endPage = Math.min(totalPageCount, currentPage + 2);

        // 첫 페이지와 마지막 페이지 추가
//        if (startPage > 1) {
//            pageNumbers.add(1);
//            if (startPage > 2) {
//                pageNumbers.add(-1); // 생략 페이지 표시
//            }
//        }

        // 현재 페이지 포함, 이전/다음 페이지 추가
        for (int i = startPage; i <= endPage; i++) {
            pageNumbers.add(i);
        }
//
//        // 마지막 페이지와 총 페이지 수 추가
//        if (endPage < totalPageCount) {
//            if (endPage < totalPageCount - 1) {
//                pageNumbers.add(-1); // 생략 페이지 표시
//            }
//            pageNumbers.add(totalPageCount);
//        }


        System.out.println("pageNumbers = " + pageNumbers);

    }

    @Test
    void getNumber() {
        int currentPage = 0;
        int totalPageCount = 5;
        // 페이징 번호 목록을 담을 리스트 생성
        List<Integer> pageNumbers = new ArrayList<>();

        // 총 페이지 수가 5개 이하이면 모든 페이지 번호 추가
        if (totalPageCount <= 5) {
            for (int i = 1; i <= totalPageCount; i++) {
                pageNumbers.add(i);
            }
        }

        int startPage = Math.max(1, currentPage - 2);
        System.out.println("startPage = " + startPage);
        int endPage = Math.min(totalPageCount, currentPage + 2);
        System.out.println("endPage = " + endPage);


        System.out.println("pageNumbers = " + pageNumbers);
    }
}