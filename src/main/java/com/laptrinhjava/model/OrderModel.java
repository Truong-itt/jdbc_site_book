package com.laptrinhjava.model;

import java.util.Date;
import java.util.List;

public class OrderModel extends AbstractModel<RoleModel>{
    private int userId;
    private Date orderDate;
    private double totalAmount;
    private List<OrderItemModel> orderItems; 
}
