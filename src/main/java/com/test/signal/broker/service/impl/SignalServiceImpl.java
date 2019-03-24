package com.test.signal.broker.service.impl;

import com.test.signal.broker.model.Signal;
import com.test.signal.broker.repository.SignalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalServiceImpl implements com.test.signal.broker.service.SignalService {

    @Autowired
    private SignalRepository signalRepository;

    @Override
    public Iterable<Signal> getAllSignals() {
        return signalRepository.findAll();
    }

    @Override
    public Signal getSignalById(long id) {
        return signalRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSignalById(long id) {
        signalRepository.deleteById(id);
    }

    @Override
    public void updateSignal(Signal signal) {
        signalRepository.save(signal);
    }

    @Override
    public void createSignal(Signal signal) {
        signalRepository.save(signal);
    }
}
