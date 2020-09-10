package com.kcymerys.java.operationprocessor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Operation implements Serializable {

    private Double arg1;
    private Double arg2;
    private OperationType operation;
    private Double result;

}
