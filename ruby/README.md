# National Debt API - Ruby Gem

National Debt provides the US national debt (Debt to the Penny), updated daily from the Treasury. It returns the total public debt, debt held by the public, intragovernmental holdings, per-capita debt calculations, the previous record's total, and on paid plans how much the debt grew over a day, 30 days and a year.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_nationaldebt'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_nationaldebt
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_nationaldebt'

# Initialize the client
client = APIVerve::Nationaldebt::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  date: "2023-06-15",
  changes: true
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ date: "2023-06-15", changes: true })
  puts response["data"]
rescue APIVerve::Nationaldebt::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Nationaldebt::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Nationaldebt::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "date": "2026-10-26",
    "recordDate": "2026-10-26",
    "totalDebt": 40528358939415.85,
    "totalDebtFormatted": "$40.53 trillion",
    "publicDebt": 32635294814294.48,
    "publicDebtFormatted": "$32.64 trillion",
    "intragovernmentalDebt": 7893064125121.37,
    "intragovernmentalDebtFormatted": "$7.89 trillion",
    "perCapita": 120980,
    "perCapitaFormatted": "$120,980",
    "population": 335000000,
    "publicDebtRatio": 80.52,
    "perHousehold": 302450.44,
    "perHouseholdFormatted": "$302,450",
    "previousDebt": 40463151897249.19,
    "previousDate": "2026-10-23",
    "change1d": 65207042166.66,
    "change30d": 431180819664.95,
    "change1y": 2519332979958.45,
    "changePercent1y": 6.6282,
    "averageDailyChange30d": 13909058698.87
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/nationaldebt?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/nationaldebt?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/nationaldebt?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
