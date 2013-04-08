package org.ddk.spring.store.domain.logic;

import org.ddk.spring.store.domain.Order;

public interface OrderService {
    
    Order getOrder(int id);
    
}
