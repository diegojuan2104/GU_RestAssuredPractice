package data;

import org.testng.annotations.DataProvider;

import java.util.Map;

import static utils.Utils.readDataFromJson;

public class Provider {

  @DataProvider(name = "Data_starWarsTestE2E")
  public Object[][] additionData() {
    Map<String, Object> dataMap = readDataFromJson("src/main/resources/DataFiles/data.json");

    return new Object[][] {
        { dataMap },
    };
  }
}
