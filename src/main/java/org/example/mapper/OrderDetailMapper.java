package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.OrderDetail;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    List<OrderDetail> getAllOrderDetail();
    List<OrderDetail> getAllOrderDetailById(Integer orderId);
}
