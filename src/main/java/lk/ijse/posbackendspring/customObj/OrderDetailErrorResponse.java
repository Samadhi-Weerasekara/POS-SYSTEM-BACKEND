package lk.ijse.posbackendspring.customObj;

import java.io.Serializable;

public class OrderDetailErrorResponse implements OrderDetailResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
