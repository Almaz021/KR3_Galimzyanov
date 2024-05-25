public class FileData {
    private int sz; // размер блока данных
    private byte[] data; // данные с фрагментом картинки
    private int even; // контрольное число четности
    private int part; // номер фрагмента картинки [0..7]

    public int getSz() {
        return sz;
    }

    public byte[] getData() {
        return data;
    }

    public int getEven() {
        return even;
    }

    public int getPart() {
        return part;
    }

    public FileData(int sz, int even, byte[] data, int part) {
        this.sz = sz;
        this.even = even;
        this.data = data;
        this.part = part;
    }
}
