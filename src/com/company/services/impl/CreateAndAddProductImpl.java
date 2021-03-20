package com.company.services.impl;
import java.util.*;

import com.company.enums.Unit;
import com.company.models.Product;
import com.company.services.CreateAndAddProduct;
import com.company.services.output;

public class CreateAndAddProductImpl implements CreateAndAddProduct, output {


    Scanner scanner = new Scanner(System.in);

    LinkedHashSet products = new LinkedHashSet();
    LinkedHashSet productsOZ = new LinkedHashSet();
    LinkedHashSet productsId = new LinkedHashSet();

    HashMap<Integer, Product> productsHM;
    Stack<Integer> stackProduct = new Stack<>();

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

            System.out.print("GR, KG, LTR, PEACE. Выберите измерения: ");
            String unit = scanner.next();
            Unit productStatus = Unit.valueOf(unit);

            Product product = new Product(id, productName, kindName, amount, productStatus);
            //Product productId = new Product(id);
            Product productOZ = new Product(productName, kindName, amount, productStatus);


            products.add(product); // общий прод
            productsOZ.add(productOZ); // для мап значения
            productsId.add(id); // для ID

            productsHM = new HashMap<>();

            productsHM.putIfAbsent(id, productOZ);


            for(Map.Entry entry: productsHM.entrySet()) {
                stackProduct.push((Integer) entry.getKey());
            }


        }while (answer.equals("yes"));

        return true;
    }

    @Override
    public void outputStackKey() {
        System.out.println("Ключи");
        for(int i=0; i<productsOZ.size(); i++) {
            System.out.println(stackProduct.pop());
        }

    }

    @Override
    public void outputListProduct() {
        int n;

        do {

            System.out.print("Введите id продукта - ");
            n = scanner.nextInt();

            ArrayList myListHM = new ArrayList(productsOZ);
            ArrayList myListID = new ArrayList(productsId);


            HashMap<Integer, Object> myHMlist = new HashMap<>(); int k;
            for(int i=0; i<myListHM.size(); i++){
                myHMlist.putIfAbsent((Integer) myListID.get(i), myListHM.get(i));
                //System.out.println(myListHM.get(i));
            }

            for(Map.Entry entry: myHMlist.entrySet()){
                if(entry.getKey().equals(n)){
                    System.out.println(entry.getValue());
                }
            }

            System.out.print("Нажмите 'n' для выхода - ");
            String no = scanner.next();
            if(no.equals("n")){
                break;
            }

        }while(true);

    }
}
