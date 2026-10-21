# National Debt API - Ruby Gem

National Debt provides real-time access to the US national debt (Debt to the Penny). It returns the total public debt, debt held by the public, intragovernmental holdings, and per-capita debt calculations.

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
response = client.execute({ date: "2023-06-15" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ date: "2023-06-15" })
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
    "date": "2026-09-14",
    "recordDate": "2026-09-14",
    "totalDebt": 40054421967786.91,
    "totalDebtFormatted": "$40.05 trillion",
    "publicDebt": 32358452350574.73,
    "publicDebtFormatted": "$32.36 trillion",
    "intragovernmentalDebt": 7695969617212.18,
    "intragovernmentalDebtFormatted": "$7.70 trillion",
    "perCapita": 119565,
    "perCapitaFormatted": "$119,565",
    "population": 335000000,
    "publicDebtRatio": 80.79,
    "perHousehold": 298913.6,
    "perHouseholdFormatted": "$298,914"
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
