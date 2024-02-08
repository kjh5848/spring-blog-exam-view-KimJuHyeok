package shop.mtcoding.blog.board;


import lombok.Data;

public class BoardRequest {
    @Data
    public static class saveDTO {
        private String author;
        private String title;
        private String content;
    }

    @Data
    public static class updateDTO {
        private String author;
        private String title;
        private String content;
    }

}
