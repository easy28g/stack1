package com.company.services;

import com.company.services.impl.CreateAndAddProductImpl;

public interface CreateAndAddProduct {

    CreateAndAddProduct INSTANCE = new CreateAndAddProductImpl();

    boolean createAndAddProduct();
}
