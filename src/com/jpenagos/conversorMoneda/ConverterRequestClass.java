package com.jpenagos.conversorMoneda;

import com.google.gson.Gson;
import com.jpenagos.conversorMoneda.records.ExchangeRateRecord;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConverterRequestClass {

  private final Map<String, String> rate = this.makeRequest().conversion_rates();

  private ExchangeRateRecord makeRequest() {
    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("https://v6.exchangerate-api.com/v6/73dc9d3a9c0a3f6b777d28ea/latest/USD"))
      .build();

    try {
      HttpResponse<String> response = client
        .send(request, HttpResponse.BodyHandlers.ofString());

      return new Gson().fromJson(response.body(), ExchangeRateRecord.class);

    } catch (Exception e) {
      throw new RuntimeException("No se puede convertir");
    }

  }

  public Map<String, String> getRate() {
    return this.rate;
  }
}
