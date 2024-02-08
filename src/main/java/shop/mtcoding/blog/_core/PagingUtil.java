package shop.mtcoding.blog._core;

import java.util.ArrayList;
import java.util.List;

public class PagingUtil {

    //페이지 번호 엑티브
    public static boolean isActive(int currentPage, List<Integer> pageNumbers) {
        for (int pageNumber : pageNumbers) {
            System.out.println("pageNumber = " + pageNumber);
            // 현재 페이지 번호와 비교하는 로직
            if (pageNumber == currentPage) {
                // 현재 페이지인 경우 처리
                System.out.println("현재 페이지: " + pageNumber);
                return true;
            }
        }
        return false;
    }

    //페이지 번호
    public static List<Integer> getPageNumbers(int currentPage, int totalPageCount) {
        System.out.println("totalPageCount = " + totalPageCount);

        // 페이징 번호 목록을 담을 리스트 생성
        List<Integer> pageNumbers = new ArrayList<>();

        // 총 페이지 수가 5개 이하이면 모든 페이지 번호 추가
        if (totalPageCount <= 5) {
            for (int i = 0; i <= totalPageCount - 1; i++) {
                pageNumbers.add(i);
            }
        }
        return pageNumbers;
    }

    //첫 페이지
    public static boolean isFirst(int currentPage) {
        return currentPage == 0 ? true : false;
    }

    //라스트페이지
    public static boolean isLast(int currentPage, int totalCount) {
        int totalPageCount = getTotalPageCount(totalCount);
        return currentPage + 1 == totalPageCount ? true : false;
    }

    //총 페이지
    public static int getTotalPageCount(int totalCount) {

        int remainCount = totalCount % Constant.PAGING_COUNT;

        System.out.println("remainCount = " + remainCount);
        int totalPageCount = totalCount / Constant.PAGING_COUNT;


        if (remainCount > 0) {
            totalPageCount = totalPageCount + 1;
        }
        System.out.println("totalPageCount = " + totalPageCount);
        return totalPageCount;
    }

}
