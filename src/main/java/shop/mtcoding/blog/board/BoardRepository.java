package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blog._core.Constant;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    @Transactional
    public void save(BoardRequest.saveDTO requesetSTO) {
        Query query = em.createNativeQuery("insert into board_tb(author, title, content) values (?,?,?)");
        query.setParameter(1, requesetSTO.getAuthor());
        query.setParameter(2, requesetSTO.getTitle());
        query.setParameter(3, requesetSTO.getContent());
        query.executeUpdate();
    }

    public List<Board> findAll(int page) {
        int value = page*Constant.PAGING_COUNT;
        Query query = em.createNativeQuery("select * from board_tb order by id desc limit ?,?", Board.class);
        query.setParameter(1, value);
        query.setParameter(2, Constant.PAGING_COUNT);

        return query.getResultList();
    }

    @Transactional
    public void delete(int id) {
        Query query = em.createNativeQuery("delete from board_tb where id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    @Transactional
    public void update(BoardRequest.updateDTO requestDTO, int id) {
        Query query = em.createNativeQuery("update board_tb set author = ?, title = ?, content = ? where id = ?");
        query.setParameter(1, requestDTO.getAuthor());
        query.setParameter(2, requestDTO.getTitle());
        query.setParameter(3, requestDTO.getContent());
        query.setParameter(4, id);
        query.executeUpdate();
    }

    public Board findById(int id) {
        Query query = em.createNativeQuery("select * from board_tb where id = ?", Board.class);
        query.setParameter(1, id);
        Board board = (Board) query.getSingleResult();
        return board;
    }

    public int count() {
        Query query = em.createNativeQuery("SELECT count(*) FROM BOARD_TB");
        int totalCount = ((Number) query.getSingleResult()).intValue();
        return totalCount;
    }
}
