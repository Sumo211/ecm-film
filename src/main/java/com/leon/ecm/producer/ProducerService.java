package com.leon.ecm.producer;

import java.util.List;

public interface ProducerService {

    List<Producer> findAll();

    Producer save(Producer producer);

    Producer findOne(Long id);

    Producer update(Long id, Producer producer);

    void delete(Long id);

}
