package finalexam.task5;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CommunicationManager {

    private String endpoint;

    public CommunicationManager(String endpoint) {
        this.endpoint = endpoint;
    }

    public String sendUserMessage(String message) {
        try {
            // Create URL object
            URL url = new URL(endpoint);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Set the request content-type header to application/json
            connection.setRequestProperty("Content-Type", "application/json; utf-8");

            // Set the connection to output mode to send a request body
            connection.setDoOutput(true);

            // Create the JSON request body
            String jsonInputString = "{\"message\": \"" + message + "\"}";

            // Write the JSON request body to the output stream
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Check if the request was successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return "Message sent successfully";
            } else {
                return "Failed to send message: " + responseCode;
            }

        } catch (Exception e) {
            return "Exception occurred: " + e.getMessage();
        }
    }
}
