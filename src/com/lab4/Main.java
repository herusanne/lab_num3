package com.lab4;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        final int N = 10;
	Database db = new Database();
    db.add("Ivanov","Hunger games",20, 500);
        System.out.println(db);

        long timeStart = System.currentTimeMillis(), t1, t2, t3, t4, t5;
        for (int i = 0; i < N; i++) {
            db.add("John" + Math.random(), (int) (Math.random() * 100));
        }
        t1 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        db.save("db.txt");
        db.clear();
        db.load("db.txt");
        t2 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        db.serialize("db_s.txt");
        db.clear();
        db.deserialize("db_s.txt");
        t3 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        db.jacksonSerialize("students.json");
        db.clear();
        db.jacksonDeserialize("students.json");
        t4 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        db.serializeFastJSON("db_fastjson.txt");
        db.clear();
        db.deserializeFastJSON("db_fastjson.txt");
        t5 = System.currentTimeMillis() - timeStart;

        System.out.println("ArrayList of " + N + " objects");
        System.out.println("Initial Data Generation:	" + t1 + " ms");
        System.out.println("Text format Save/load:		" + t2 + " ms");
        System.out.println("Java serialization/des:		" + t3 + " ms");
        System.out.println("Jackson serialization/des:	" + t4 + " ms");
        System.out.println("FASTJson serialization/des:	" + t5 + " ms");

/*      System.out.println(db.remove(1));
        System.out.println(db);*/
    }
}
