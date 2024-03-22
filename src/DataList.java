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

  // Pencarian data value dengan menggunakan Linear Search
  public Data linearSearch(String key) {
    // Iterasi pada setiap elemen type
    for (Data data : dataList) {
        // Method pembanding data dengan kata kunci
        if (data.getDescription().equals(key)) {
            System.out.println("Data " + key + " ditemukan pada indeks ke " + data);
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
            System.out.println("Data " + key + " ditemukan pada indeks ke " + data);
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
            System.out.println("Data " + key + " berada pada indeks ke " + mid + " dengan isi " + midData.getDescription());
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
