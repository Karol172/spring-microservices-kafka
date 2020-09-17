package com.kcymerys.java.kstreamprocessor;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(StreamProcessor.class)
public class KafkaStreamProcessor {

/*    @StreamListener
    @SendTo("final-topic")
    public KStream<String, Operation> process (@Input("results-topic") KStream<String, Operation> inStream) {
        return inStream
                .filter((key, value) -> value.getOperation() == OperationType.DIVISION
                        && Math.abs(value.getArg1()) < 0.0001)
                .map((key, value) -> {
                    double temp = value.getArg1();
                    value.setArg1(value.getArg2());
                    value.setArg2(temp);
                    value.setResult(calculate(value));
                    return new KeyValue<>(key, value);
                });
    }*/

    @StreamListener(StreamProcessor.INPUT)
    public void process (@Input(StreamProcessor.INPUT) KStream<String, Operation> inStream) {
        inStream
                .peek((k, v) -> log.info(v.toString()));
    }

/*    private Double calculate (Operation operation) {
        return switch (operation.getOperation()) {
            case ADDITION -> operation.getArg1() + operation.getArg2();
            case SUBTRACTION -> operation.getArg1() - operation.getArg2();
            case MULTIPLICATION -> operation.getArg1() * operation.getArg2();
            case DIVISION -> operation.getArg1() / operation.getArg2();
        };
    }*/

}
