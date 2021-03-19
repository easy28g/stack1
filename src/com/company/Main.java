package com.company;

import com.company.services.CreateAndAddProduct;
import com.company.services.impl.CreateAndAddProductImpl;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Название товара, сорт\производитель, кол-во, единицы измерения. +
        // Только уникальные товары. +
        // Пребразовать в map -> ключ название.
        // Ключи добавить в стэк.
        // процесс покупки.
        // Получить элемент из stack и найти значение в map


        CreateAndAddProductImpl createAndAddProduct = new CreateAndAddProductImpl();
        createAndAddProduct.createAndAddProduct();
        createAndAddProduct.outputStackKey();
        createAndAddProduct.outputListProduct();
    }
}
