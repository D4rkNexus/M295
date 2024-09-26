package org.example.productmanager.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<UserData, Long> {
    // Fügen Sie diese Methode hinzu
    Optional<UserData> findByUsernameAndPassword(String username, String password);
}
