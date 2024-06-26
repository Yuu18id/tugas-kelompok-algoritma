import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataList {
  private List<Data> dataList;

  public DataList() {
    dataList = new ArrayList<>();
  }

  public void addData(Data data) {
    dataList.add(data);
  }

  public List<Data> getDataList() {
    return dataList;
  }

  // Algoritma pengurutan menggunakan Bubble Sort
  public void bubbleSort() {
    int n = dataList.size();
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (dataList.get(j).getValue() > dataList.get(j + 1).getValue()) {
                // Tukar posisi elemen jika dalam urutan yang salah
                Data temp = dataList.get(j);
                dataList.set(j, dataList.get(j + 1));
                dataList.set(j + 1, temp);
            }
        }
    }
  }

  // Pencarian data value dengan menggunakan Linear Search
  public Data linearSearch(String key) {
    // Iterasi pada setiap elemen type
    for (Data data : dataList) {
        // Method pembanding data dengan kata kunci
        if (data.getDescription().equalsIgnoreCase(key)) {
            System.out.println("\nData Ditemukan!");
            System.out.println("Nomor\t\t: "+ data.getValue() );
            System.out.println("Deskripsi\t: "+ data.getDescription() +"\n");
            return data;
        }
    }
    return null;
}

// Pencarian data description dengan menggunakan Linear Search
public Data linearSearch(int key) {
    // Iterasi pada setiap elemen type
    for (Data data : dataList) {
        // Method pembanding data dengan kata kunci
        if (data.getValue() == key) {
            System.out.println("\nData Ditemukan!");
            System.out.println("Nomor\t\t: "+ data.getValue() );
            System.out.println("Deskripsi\t: "+ data.getDescription() +"\n");
            return data;
        }
    }
    return null;
}

// Pencarian data value dengan Binary Search
public Data binarySearch(int key) {
    // Sorting data menurut indeks
    Collections.sort(dataList, (a, b) -> a.getValue() - b.getValue());

    // Batas Bawah
    int low = 0;
    // Batas Atas (Panjang Array)
    int high = dataList.size() - 1;

    while (low <= high) {
        int mid = (low + high) / 2;
        Data midData = dataList.get(mid);

        // Membandingkan value dengan key
        if (midData.getValue() == key) {
            System.out.println("\nData Ditemukan!");
            System.out.println("Nomor\t\t: "+ midData.getValue() );
            System.out.println("Deskripsi\t: "+ midData.getDescription() +"\n");
            return midData;
        } else if (midData.getValue() < key) {
            // Cari di ruas kanan
            low = mid + 1;
        } else {
            // Cari di ruas kiri
            high = mid - 1;
        }
    }
    // Tidak ketemu
    return null;
}

}
