package com.test.signal.broker.service;

import com.test.signal.broker.model.Signal;

public interface SignalService {

    Iterable<Signal> getAllSignals();

    Signal getSignalById(long id);

    void deleteSignalById(long id);

    void updateSignal(Signal signal);

    void createSignal(Signal signal);
}
