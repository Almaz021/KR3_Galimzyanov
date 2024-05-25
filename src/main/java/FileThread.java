import java.io.*;

public class FileThread implements Runnable {

    private String fileName;
    private FileData data;

    public FileData getData() {
        return data;
    }

    public FileThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            BufferedInputStream is = new BufferedInputStream(new FileInputStream(fileName));

            int b;
            byte[] num1 = new byte[4];

            is.read(num1);
            int sz = transl((num1));
            byte[] fileData = new byte[sz];
            is.read(fileData);

            byte[] num3 = new byte[4];
            is.read(num3);
            int even = transl(num3);

            byte[] num4 = new byte[4];
            is.read(num4);
            int part = transl(num4);

            if (check(fileData) == even) {
                System.out.println("Данные полные");
            }
            data = new FileData(sz, even, fileData, part);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int transl(byte[] s) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            value = (s[i] & 0xFF)+(value << 8);
        }
        return value;
    }

    public int check(byte[] d) {
        int res = 0;
        for (int i = 0; i < d.length; i++) {
            res += (int) Integer.toBinaryString(d[i]).chars().filter(item->item == '1').count();
        }
        return res%2;
    }
}
