package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.mtcoding.blog._core.PagingUtil;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;


    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "0")int page, HttpServletRequest request) {
        List<Board> boardList = boardRepository.findAll(page);
        int currentPage = page;
        int nextPage = currentPage +1;
        int prevPage = currentPage -1;
        boolean first = PagingUtil.isFirst(currentPage);
        boolean last = PagingUtil.isLast(currentPage,boardRepository.count());
        List<Integer> pageNumbers = PagingUtil.getPageNumbers(currentPage+1, PagingUtil.getTotalPageCount(boardRepository.count()));

        request.setAttribute("boardList", boardList);
        request.setAttribute("first",first);
        request.setAttribute("last",last);
        request.setAttribute("pageNumber", pageNumbers);
        request.setAttribute("nextPage", nextPage);
        request.setAttribute("prevPage", prevPage);

        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, HttpServletRequest request) {

        Board board = boardRepository.findById(id);
        request.setAttribute("board", board);

        return "board/updateForm";
    }

    @PostMapping("/board/save")
    public String save(BoardRequest.saveDTO requesetSTO,HttpServletRequest request) {

        if (requesetSTO.getTitle().length() > 20 && requesetSTO.getContent().length() > 20) {
             request.setAttribute("status", 400);
             request.setAttribute("msg", "제목과 내용은 20자를 넘어갈 수 었습니다.");
            return "error/40x";
        }
        boardRepository.save(requesetSTO);

        return "redirect:/";
    }

    @PostMapping("/board/{id}/update")
    public String update(@PathVariable int id, BoardRequest.updateDTO requestDTO) {

        System.out.println("requestDTO = " + requestDTO);

        boardRepository.update(requestDTO, id);

        return "redirect:/";
    }

    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable int id) {
        boardRepository.delete(id);

        return "redirect:/";
    }
}
