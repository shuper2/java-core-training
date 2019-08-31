package session34.patterns.singleton;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

class DeserializeDemo {
    public static void main(String[] args) throws Exception {
        SingletonEager singletonEager = SingletonEager.getInstance();
        SingletonEager deserialized = null;
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream objo = new ObjectOutputStream(bo);
        objo.writeObject(singletonEager);
        objo.close();
        ObjectInputStream obji = new ObjectInputStream(new ByteArrayInputStream(bo.toByteArray()));
        deserialized = (SingletonEager) obji.readObject();

        assertThat(deserialized).isNotNull();
        System.out.println(singletonEager + "|" + deserialized);
        assertThat(deserialized).isSameAs(singletonEager);
    }
}

class DeserializeDemo2 {
    public static void main(String[] args) throws Exception {
        SingletonEager2 singletonEager = SingletonEager2.INSTANCE;
        SingletonEager2 deserialized = null;
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream objo = new ObjectOutputStream(bo);
        objo.writeObject(singletonEager);
        objo.close();
        ObjectInputStream obji = new ObjectInputStream(new ByteArrayInputStream(bo.toByteArray()));
        deserialized = (SingletonEager2) obji.readObject();

        assertThat(deserialized).isNotNull();
        System.out.println(singletonEager + "|" + deserialized);
        assertThat(deserialized).isSameAs(singletonEager);
    }
}