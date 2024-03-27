package ru.ilyam.messageboardengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ilyam.messageboardengine.entity.Message;

import java.util.Set;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("select msg from Message msg join msg.topic topic where topic.id = :topicId")
    Set<Message> findAllByTopicId(@Param("topicId") Long topicId);

}
