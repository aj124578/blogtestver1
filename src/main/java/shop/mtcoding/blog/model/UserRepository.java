package shop.mtcoding.blog.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {
    public List<User> findAll();

    public User findById(int id);

    public int insert(@Param("username") String username, @Param("password") String password, @Param("passwordCheck") String passwordCheck, @Param("email") String email);

    public int updateByUserId(@Param("password") String password, @Param("email") String email);

    public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
