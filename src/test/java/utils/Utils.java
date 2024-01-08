package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Utils {

  /**
   * Validates if a given date string matches the "YYYY-MM-DD" format using regular expressions.
   *
   * @param dateString The date string to validate in "YYYY-MM-DD" format.
   * @return true if the date string matches "YYYY-MM-DD" format, otherwise false.
   */
  public static boolean isValidYYYYMMDDFormat(String dateString) {
    return dateString.matches("\\d{4}-\\d{2}-\\d{2}");
  }
  /**
   * Reads JSON data from a file and parses it into a Map.
   *
   * @param jsonPath Path to the JSON file.
   * @return A Map representing the JSON data.
   * @throws RuntimeException if there's an issue reading or parsing the JSON file.
   */
  public static Map<String, Object> readDataFromJson(String jsonPath) {
    try {
      // Read JSON file content as a string
      final String json = new String(Files.readAllBytes(Paths.get(jsonPath)), StandardCharsets.UTF_8);

      final ObjectMapper mapper = new ObjectMapper();

      final MapType type = mapper.getTypeFactory().constructMapType(
          Map.class, String.class, Object.class);

      // Parse JSON into a Map
      return mapper.readValue(json, type);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
