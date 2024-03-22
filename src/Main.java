import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataList dataList = new DataList();

        // data dummy
        int[] ListValue = { 2, 45, 25, 3, 7, 4, 8, 4, 9, 76, 34, 12, 96, 45, 73, 27, 97, 34, 11, 18, 80 };
        String[] lists = { "apel", "jeruk", "pisang", "mangga", "anggur", "stroberi", "nanas", "meja", "kursi",
                "lemari", "lampu", "buku", "pensil", "pakaian", "komputer", "mobil", "sepeda", "televisi", "kamera",
                "jam", "boneka" };
        for (int i = 0; i < lists.length; i++) {
            Data d = new Data(ListValue[i], lists[i]);
            dataList.addData(d);
        }

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nAplikasi Pencarian dan Pengurutan - Kelompok 5");
            System.out.println("Menu:");
            System.out.println("1. Tambah Data");
            System.out.println("2. Urutkan Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Tes Kinerja Algoritma");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka.");
                scanner.nextLine(); // Membersihkan buffer
                continue;
            }
            scanner.nextLine(); // Membersihkan buffer

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Masukkan Nilai: ");
                        int value = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan buffer
                        System.out.print("Masukkan Deskripsi: ");
                        String description = scanner.nextLine();
                        Data newData = new Data(value, description);
                        dataList.addData(newData);
                        System.out.println("Data telah ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input nilai harus berupa angka.");
                        scanner.nextLine(); // Membersihkan buffer
                    }
                    break;
                case 2:
                    dataList.bubbleSort();
                    System.out.println("\nData setelah diurutkan:");
                    for (Data data : dataList.getDataList()) {
                        System.out.println("Nilai: " + data.getValue() + ", Deskripsi: " + data.getDescription());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("\nPilih Algoritma Pencarian:");
                        System.out.println("1. Linear Search");
                        System.out.println("2. Binary Search");
                        System.out.print("Pilihan: ");
                        int searchAlgoValue = scanner.nextInt();
                        scanner.nextLine(); // Membersihkan buffer
                        if (searchAlgoValue == 1) {
                            System.out.println("\nPilih Tipe Data yang Ingin Dicari:");
                            System.out.println("1. Nomor");
                            System.out.println("2. Deskripsi");
                            System.out.print("Pilihan: ");
                            int searchType = scanner.nextInt();
                            scanner.nextLine(); // Membersihkan buffer
                            System.out.print("Masukkan nilai yang ingin dicari: ");

                            if (searchType == 1) {
                                int searchValue = scanner.nextInt();
                                scanner.nextLine(); // Membersihkan buffer
                                dataList.linearSearch(searchValue);
                            } else if (searchType == 2) {
                                String searchValue = scanner.nextLine();
                                dataList.linearSearch(searchValue);
                            } else {
                                System.out.println("Pilihan Tidak Valid");
                            }
                        } else if (searchAlgoValue == 2) {
                            int searchValue = scanner.nextInt();
                            scanner.nextLine(); // Membersihkan buffer
                            dataList.binarySearch(searchValue);
                        } else {
                            System.out.println("Pilihan tidak valid");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka.");
                        scanner.nextLine(); // Membersihkan buffer
                    }
                    break;
                case 4:
                    System.out.println("\n PROSES TESTING...");
                    long startTimeLinearSearch = System.nanoTime();
                    Data ls = dataList.linearSearch(18);
                    long endTimeLinearSearch = System.nanoTime();
                    long durationLinearSearch = (endTimeLinearSearch - startTimeLinearSearch);

                    // Measure execution time of binary search
                    long startTimeBinarySearch = System.nanoTime();
                    Data bs = dataList.binarySearch(18);
                    long endTimeBinarySearch = System.nanoTime();
                    long durationBinarySearch = (endTimeBinarySearch - startTimeBinarySearch);

                    // Measure execution time of bubble sort
                    long startTimeBubbleSort = System.nanoTime();
                    dataList.bubbleSort();
                    long endTimeBubbleSort = System.nanoTime();
                    long durationBubbleSort = (endTimeBubbleSort - startTimeBubbleSort);

                    // Output the durations
                    System.out.println("Kecepatan Eksekusi Algoritma Linear Search: " + durationLinearSearch + " nanodetik");
                    System.out.println("Kecepatan Eksekusi Algoritma Binary Search: " + durationBinarySearch + " nanodetik");
                    System.out.println("Kecepatan Eksekusi Algoritma Bubble Sort: " + durationBubbleSort + " nanodetik");
                    System.out.println("\nKesimpulan:");
                    if (durationBinarySearch < durationLinearSearch) {
                        System.out.println("1. Binary Search lebih cepat dibandingkan dengan Linear Search.");
                    } else {
                        System.out.println("1. Linear Search lebih cepat dibandingkan dengan Binary Search.");
                    }
                    System.out.println("2. Algoritma Bubble Sort lumayan cepat.");
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }
}
