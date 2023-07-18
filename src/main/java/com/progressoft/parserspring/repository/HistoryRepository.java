package com.progressoft.parserspring.repository;

import com.progressoft.parserspring.database.History;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<History, Integer> {
    History findByFileName(String fileName);
}
