package com.leon.ecm.producer;

import com.leon.ecm.common.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProducerServiceImpl implements ProducerService {

    private final ProducerRepository producerRepository;

    public ProducerServiceImpl(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @Override
    public List<Producer> findAll() {
        return producerRepository.findAll();
    }

    @Override
    public Producer save(Producer producer) {
        return producerRepository.save(producer);
    }

    @Override
    public Producer findOne(Long id) {
        Producer producer = producerRepository.findOne(id);
        if (producer == null) throw new ResourceNotFoundException("Cannot find producer with Id is " + id);
        return producer;
    }

    @Override
    public Producer update(Long id, Producer producer) {
        Producer currentProducer = producerRepository.findOne(id);
        if (producer == null) {
            throw new ResourceNotFoundException("Cannot find producer with Id is " + id);
        } else {
            currentProducer.setName(producer.getName());
            currentProducer.setCountry(producer.getCountry());
            return producerRepository.save(currentProducer);
        }
    }

    @Override
    public void delete(Long id) {
        Producer currentProducer = producerRepository.findOne(id);
        if (currentProducer == null) {
            throw new ResourceNotFoundException("Cannot find producer with Id is " + id);
        } else {
            producerRepository.delete(currentProducer);
        }
    }

}
