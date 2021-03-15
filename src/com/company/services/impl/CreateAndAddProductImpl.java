package com.company.services.impl;
import java.util.*;

import com.company.enums.Unit;
import com.company.models.Product;
import com.company.services.CreateAndAddProduct;

public class CreateAndAddProductImpl implements CreateAndAddProduct {


    Scanner scanner = new Scanner(System.in);

//    LinkedHashSet<Product> productsID = new LinkedHashSet<>();
    LinkedHashSet<Product> products = new LinkedHashSet<>();
    LinkedHashSet<Product> productsOZ = new LinkedHashSet<>();

    HashMap<Integer, LinkedHashSet> productsHM = new HashMap<>();
    Stack<HashMap> stackProduct = new Stack<>();

    @Override
    public boolean createAndAddProduct() {

        String answer;
        do {

            System.out.print("Вы хотите добавить продукт. Выберите yes/no: ");
            answer = scanner.next();

            if (answer.equals("no")){
                break;
            }

            System.out.print("ID продукта: ");
            int id = scanner.nextInt();

            System.out.print("Введите название продукта: ");
            String productName = scanner.next();

            System.out.print("Сорт/производитель: ");
            String kindName = scanner.next();

            System.out.print("Введите количество: ");
            double amount = scanner.nextDouble();

            System.out.print("GR, KG, LTR, PIECE. Выберите измерения: ");
            String unit = scanner.next();
            Unit productStatus = Unit.valueOf(unit);

            Product product = new Product(id, productName, kindName, amount, productStatus);
//            Product productID = new Product(id);
            Product productOZ = new Product(productName, kindName, amount, productStatus);

//            productsID.add(productID); // для мап ключа
            products.add(product); // общий прод
            productsOZ.add(productOZ); // для мап значения
            productsHM = new HashMap<>();

            productsHM.putIfAbsent(id, productsOZ);
            stackProduct.push(productsHM);


        }while (answer.equals("yes"));
        System.out.println(productsHM);
        System.out.println(stackProduct.pop());
        System.out.println(stackProduct.pop());
        return true;
    }
}
