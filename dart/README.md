# National Debt API - Dart/Flutter Client

National Debt provides the US national debt (Debt to the Penny), updated daily from the Treasury. It returns the total public debt, debt held by the public, intragovernmental holdings, per-capita debt calculations, the previous record's total, and on paid plans how much the debt grew over a day, 30 days and a year.

[![pub package](https://img.shields.io/pub/v/apiverve_nationaldebt.svg)](https://pub.dev/packages/apiverve_nationaldebt)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [National Debt API](https://apiverve.com/marketplace/nationaldebt?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_nationaldebt: ^1.2.5
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_nationaldebt/apiverve_nationaldebt.dart';

void main() async {
  final client = NationaldebtClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'date': '2023-06-15',
      'changes': true
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [National Debt API](https://apiverve.com/marketplace/nationaldebt?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/nationaldebt](https://docs.apiverve.com/ref/nationaldebt?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
