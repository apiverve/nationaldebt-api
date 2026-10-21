# National Debt API - PHP Package

National Debt provides real-time access to the US national debt (Debt to the Penny). It returns the total public debt, debt held by the public, intragovernmental holdings, and per-capita debt calculations.

## Installation

Install via Composer:

```bash
composer require apiverve/nationaldebt
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Nationaldebt\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['date' => '2023-06-15']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Nationaldebt\Client;
use APIVerve\Nationaldebt\Exceptions\APIException;
use APIVerve\Nationaldebt\Exceptions\ValidationException;

try {
    $response = $client->execute(['date' => '2023-06-15']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/nationaldebt?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/nationaldebt?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/nationaldebt?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
