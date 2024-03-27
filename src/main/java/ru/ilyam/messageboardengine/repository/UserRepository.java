package ru.ilyam.messageboardengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ilyam.messageboardengine.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
