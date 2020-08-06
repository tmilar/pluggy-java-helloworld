package ai.pluggy;

import ai.pluggy.client.PluggyClient;
import ai.pluggy.client.request.ConnectorsSearchRequest;
import ai.pluggy.client.response.ConnectorsResponse;
import ai.pluggy.client.response.ErrorResponse;
import java.io.IOException;
import java.util.Arrays;
import retrofit2.Response;

public class HelloPluggyJava {

  public static final String CLIENT_ID = System.getenv("PLUGGY_CLIENT_ID");
  public static final String CLIENT_SECRET = System.getenv("PLUGGY_CLIENT_SECRET");

  public static void main(String[] args) throws IOException {
    // Use builder to create a client instance
    PluggyClient pluggyClient = PluggyClient.builder()
      .clientIdAndSecret(CLIENT_ID, CLIENT_SECRET)
      .baseUrl("https://api.pluggy.ai")
      .build();

    // Define some request params (optional)
    ConnectorsSearchRequest connectorsSearchRequest = new ConnectorsSearchRequest(
      "Pluggy",
      Arrays.asList("AR")
    );

    // Synchronously perform a request
    Response<ConnectorsResponse> connectorsResponse = pluggyClient.service()
      .getConnectors(connectorsSearchRequest)
      .execute();

    // Read response data (or error):
    if (connectorsResponse.isSuccessful()) {
      // successful -> get body
      ConnectorsResponse connectorsResponseBody = connectorsResponse.body();
      System.out.println("Got connectors response body OK! \n" + connectorsResponseBody);
    } else {
      // unsuccessful -> parse error data
      ErrorResponse errorResponse = pluggyClient.parseError(connectorsResponse);
      System.out.println("Got connectors response error \n" + errorResponse);
    }
  }

}
