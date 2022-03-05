package ru.yvzorin.someservice;

import ru.yvzorin.someservice.domain.model.kafedra.Kafedra;

import java.util.*;

/**
 * @author Yury Zorin <yuri.zorin@bostongene.com>
 */
public class Main {

    public static void ain(String[] args) {

//        long d;// 8 байт
//        int a = 0; //4 байта    !
//        short b; //2 байта
//        byte c; // -127; 127 +-
//
//        char e = '0'; // символьный тим, например 'Q'
//
//        float g; // 12.31241
//        double f; // 12.12312314   !
//
//        boolean h; // true false    !
//        if (a == 0) {
//            b = 5;
//        } else {
//            System.out.println(e);
//        }
//        switch (e) {
//            case 'a': {
//                b = 5;
//            }
//            break;
//            case 'b': {
//                b = 6;
//            }
//            break;
//            default: {
//                b = 8;
//            }
//            break;
//        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
//        int index = 0;
//        do {
//            System.out.println("текущий индекс" + index);
//            index++;
//        }
//        while (index < 100);
//
//        Struct a = {1, 4};
//
//        a.scont
//        Kafedra kaf = new Kafedra("Никитаев", "Проничев", 2000, 46);
//
//        kaf.printInformation();
//
//        kaf.changeZavKaf("Проничев");
//        kaf.changeZamZavkaf("Поляков");
//
//        kaf.printInformation();
//
//
//        Kafedra kafedras[] = {new Kafedra("Никитаев", "Проничев", 2000, 46),
//                new Kafedra("Иванов", "Гуров", 1970, 12)};
//
//        Kafedra kafedras1[] = new Kafedra[120];
//
//        kafedras1[0] = new Kafedra("Никитаев", "Проничев", 2000, 46);
//
//        try {
//            kafedras1[0].methodWithException();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        try {
//            new Kafedra("Никитаев", "Проничев", -2000, -46);
//        }
//        catch (Exception e)
//        {
//            System.out.println("Мы отловили эксепшн:" + e.getMessage());
//        }

        List<Kafedra> kafedras = new ArrayList<>();
        kafedras.add(new Kafedra("Никитаев", "Проничев", 2000, 46));
        kafedras.add(new Kafedra("Иванов", "Гуров", 1970, 12));


        Set<Kafedra> kafSet = new HashSet<>();

        kafSet.add(new Kafedra("Никитаев", "Проничев", 2000, 46));
        kafSet.add(new Kafedra("Иванов", "Гуров", 1970, 12));
        kafSet.add(new Kafedra("Иванов", "Гуров", 1970, 12));
        kafSet.add(new Kafedra("Иванов", "Гуров", 1970, 12));
        kafSet.add(new Kafedra("Иванов", "Гуров", 1970, 12));
        kafSet.add(new Kafedra("Иванов", "Гуров", 1970, 12));
        kafSet.add(new Kafedra("Иванов", "Гуров", 1970, 12));


        Map<Integer, Kafedra> kafMap = new HashMap<>();
        kafMap.put(12, new Kafedra("Иванов", "Гуров", 1970, 12));
        kafMap.put(46, new Kafedra("Никитаев", "Проничев", 2000, 46));

        kafMap.get(46).printInformation();


    }
}
