package ru.ilyam.messageboardengine.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.ilyam.messageboardengine.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    Page<Topic> findAll(Pageable pageable);
}
