package com.test.signal.broker.repository;

import com.test.signal.broker.model.Signal;
import org.springframework.data.repository.CrudRepository;

public interface SignalRepository extends CrudRepository<Signal, Long> {
}
