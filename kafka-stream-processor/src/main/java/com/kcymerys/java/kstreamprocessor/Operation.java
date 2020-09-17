package com.kcymerys.java.kstreamprocessor;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class Operation implements Serializable {

    private Double arg1;
    private Double arg2;
    private OperationType operation;
    private Double result;

}
