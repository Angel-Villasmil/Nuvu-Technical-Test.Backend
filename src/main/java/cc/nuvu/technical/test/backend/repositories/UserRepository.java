package cc.nuvu.technical.test.backend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cc.nuvu.technical.test.backend.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    @Query(value="SELECT * FROM user WHERE username = :usr and password = :pwd", nativeQuery=true)
    UserModel getValidUser(@Param("usr") String usr, @Param("pwd") String pwd);
}
