import javax.imageio.ImageIO;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Integer, byte[]> map;
    public static void main(String[] args) throws FileNotFoundException {
        map = new HashMap<>();
        start();
    }

    public static void start() {
        FileThread f1 = new FileThread("src\\main\\resources\\v9\\1.txt");
        FileThread f2 = new FileThread("src\\main\\resources\\v9\\2.txt");
        FileThread f3 = new FileThread("src\\main\\resources\\v9\\3.txt");
        FileThread f4 = new FileThread("src\\main\\resources\\v9\\4.txt");
        FileThread f5 = new FileThread("src\\main\\resources\\v9\\5.txt");
        FileThread f6 = new FileThread("src\\main\\resources\\v9\\6.txt");
        FileThread f7 = new FileThread("src\\main\\resources\\v9\\7.txt");
        FileThread f8 = new FileThread("src\\main\\resources\\v9\\8.txt");
        Thread thread1 = new Thread(f1);
        Thread thread2 = new Thread(f2);
        Thread thread3 = new Thread(f3);
        Thread thread4 = new Thread(f4);
        Thread thread5 = new Thread(f5);
        Thread thread6 = new Thread(f6);
        Thread thread7 = new Thread(f7);
        Thread thread8 = new Thread(f8);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
            thread8.join();
            map.put(f1.getData().getPart(), f1.getData().getData());
            map.put(f2.getData().getPart(), f2.getData().getData());
            map.put(f3.getData().getPart(), f3.getData().getData());
            map.put(f4.getData().getPart(), f4.getData().getData());
            map.put(f5.getData().getPart(), f5.getData().getData());
            map.put(f6.getData().getPart(), f6.getData().getData());
            map.put(f7.getData().getPart(), f7.getData().getData());
            map.put(f8.getData().getPart(), f8.getData().getData());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String fileName = "src\\main\\resources\\v9\\1.png";


        try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(fileName))){
            for (int i = 0; i < 8; i++) {
                write(writer, i);
                writer.write(map.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void write(BufferedOutputStream writer, int i) throws IOException {
        writer.write(map.get(i));
    }

}
