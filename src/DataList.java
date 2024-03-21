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
}
