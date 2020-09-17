package com.kcymerys.java.kstreamprocessor;


import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

public interface StreamProcessor {

    String INPUT = "input";

    @Input(StreamProcessor.INPUT)
    KStream<?, ?> inputStream();


/*    @Output("final-topic")
    KStream outputStream();*/

}
