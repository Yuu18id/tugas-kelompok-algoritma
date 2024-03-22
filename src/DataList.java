import java.util.ArrayList;
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
}
