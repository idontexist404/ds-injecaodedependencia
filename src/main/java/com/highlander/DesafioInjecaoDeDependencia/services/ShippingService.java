package com.highlander.DesafioInjecaoDeDependencia.services;

import com.highlander.DesafioInjecaoDeDependencia.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public Double shipment(Order order) {
        Double basicValue = order.getBasic();

        if (basicValue < 100.0) {
            return 20.0;
        }
        if (basicValue >= 100.0 && basicValue < 200.0) {
            return 12.0;
        }
        return 0.0;
    }
}
