package com.example.demo.repository;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author ZhaoWenyue
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 根据id查找
     * @param id
     * @return
     */
    @Query(value = "select u.* from `users` u where u.id = ?1", nativeQuery = true)
    User findAccrodingId(Long id);
}
