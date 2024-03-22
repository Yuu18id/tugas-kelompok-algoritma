import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataList dataList = new DataList(); // Membuat objek untuk menyimpan daftar data

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data");
            System.out.println("2. Urutkan Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi karakter newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nilai: ");
                    int value = scanner.nextInt();
                    scanner.nextLine(); // Mengonsumsi karakter newline
                    System.out.print("Masukkan deskripsi: ");
                    String description = scanner.nextLine();
                    Data newData = new Data(value, description);
                    dataList.addData(newData); // Menambahkan data baru ke dalam daftar
                    System.out.println("Data telah ditambahkan.");
                    break;
                case 2:
                    dataList.bubbleSort(); // Mengurutkan data menggunakan algoritma bubble sort
                    System.out.println("Data setelah diurutkan:");
                    for (Data data : dataList.getDataList()) {
                        System.out.println("Nilai: " + data.getValue() + ", Deskripsi: " + data.getDescription());
                    }
                    break;
                case 3:
                    System.out.print("Masukkan nilai yang ingin dicari: ");
                    int searchValue = scanner.nextInt();
                    scanner.nextLine(); // Mengonsumsi karakter newline
                    boolean found = false;
                    for (Data data : dataList.getDataList()) {
                        if (data.getValue() == searchValue) {
                            System.out.println("Data ditemukan: " + data.getDescription());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;
                case 4:
                    isRunning = false; // Keluar dari loop while dan program
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close(); // Menutup Scanner
    }
}
