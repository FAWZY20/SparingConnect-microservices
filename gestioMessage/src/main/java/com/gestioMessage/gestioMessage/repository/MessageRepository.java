package com.gestioMessage.gestioMessage.repository;

import com.gestioMessage.gestioMessage.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
