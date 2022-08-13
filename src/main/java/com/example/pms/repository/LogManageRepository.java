package com.example.pms.repository;

import com.example.pms.model.LogManage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogManageRepository extends MongoRepository<LogManage, String> {

}
