package org.example.typeHandler;

import org.apache.ibatis.type.EnumTypeHandler;
import org.example.dto.OrderEnum;

public class OrderEnumTypeHandler extends EnumTypeHandler<OrderEnum> {
    public OrderEnumTypeHandler(Class<OrderEnum> type) {
        super(type);
    }
}
