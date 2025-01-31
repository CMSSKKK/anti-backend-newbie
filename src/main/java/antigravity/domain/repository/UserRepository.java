package antigravity.domain.repository;

import antigravity.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long userId);
}
