package com.imm.report.generator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.imm.report.generator.model.AddressModel;
import com.imm.report.generator.model.OrderEntryModel;
import com.imm.report.generator.model.OrderModel;

@Service
public class MockOrderService {

    public OrderModel getOrderByCode(final String code) {

        return order(code);

    }

    private OrderModel order(String code) {
        return new OrderModel(code, address(), entries());
    }

    private AddressModel address() {
        return new AddressModel("Mouad",
                "EL Fakir",
                "Gabriel Peri",
                "75000",
                "Paris",
                "France");
    }

    @SuppressWarnings("serial")
	private List<OrderEntryModel> entries() {
        return new ArrayList<OrderEntryModel>() {
            {
                add(new OrderEntryModel("Apple IPhone X", 1, 500d));
                add(new OrderEntryModel("Samsung Galaxy s8", 2, 400d));
            }
        };
    }
}
