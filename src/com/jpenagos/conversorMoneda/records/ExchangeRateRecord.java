package com.jpenagos.conversorMoneda.records;

import java.util.Map;

public record ExchangeRateRecord(
  String result,
  String time_last_update_utc,
  String base_code,
  Map<String, String> conversion_rates
) {

}
