package ru.ilyam.messageboardengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ilyam.messageboardengine.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}
