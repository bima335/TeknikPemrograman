public class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        this.setStok(id, stok);
    }

    public String getNamaMakanan(int id) { return nama_makanan[id]; }
    public double getHargaMakanan(int id) { return harga_makanan[id]; }
    public int getStok(int id) { return stok[id]; }

    public void setStok(int id, int stokBaru) {
        if (stokBaru >= 0) {
            this.stok[id] = stokBaru;
        } else {
            System.out.println("Error: Stok tidak boleh bernilai negatif!");
        }
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(nama_makanan[i] + "[" + stok[i] + "]" + "\tRp. " + harga_makanan[i]);
            }
        }
    }

    public boolean isOutOfStock(int id) {
        return stok[id] == 0;
    }

    public static void nextId() {
        id++;
    }

    public void pesanMenu(String nama, int jumlah) {
        for (int i = 0; i <= id; i++) {
            if (nama_makanan[i] != null && nama_makanan[i].equalsIgnoreCase(nama)) {
                if (getStok(i) >= jumlah) {
                    setStok(i, getStok(i) - jumlah);
                    System.out.println("Pesanan: " + jumlah + " x " + nama);
                } else {
                    System.out.println("Pesanan gagal: Stok " + nama + " tidak mencukupi! (Sisa stok: " + getStok(i) + ")");
                }
                return; 
            }
        }
        System.out.println("Menu " + nama + " tidak ditemukan 404.");
    }
}