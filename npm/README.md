# National Debt API

National Debt provides the US national debt (Debt to the Penny), updated daily from the Treasury. It returns the total public debt, debt held by the public, intragovernmental holdings, per-capita debt calculations, the previous record's total, and on paid plans how much the debt grew over a day, 30 days and a year.

[![npm version](https://img.shields.io/npm/v/@apiverve/nationaldebt.svg)](https://www.npmjs.com/package/@apiverve/nationaldebt)

This is a JavaScript wrapper for the [National Debt API](https://apiverve.com/marketplace/nationaldebt?utm_source=npm&utm_medium=referral&utm_content=readme)

---

## Installation

Using npm:
```shell
npm install @apiverve/nationaldebt
```

Using yarn:
```shell
yarn add @apiverve/nationaldebt
```

---

## Configuration

Before using the National Debt API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=npm&utm_medium=referral&utm_content=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=npm&utm_medium=referral&utm_content=readme)

The National Debt API documentation is found here: [https://docs.apiverve.com/ref/nationaldebt](https://docs.apiverve.com/ref/nationaldebt?utm_source=npm&utm_medium=referral&utm_content=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

```javascript
const nationaldebtAPI = require('@apiverve/nationaldebt');
const api = new nationaldebtAPI({
    api_key: '[YOUR_API_KEY]'
});
```

---

## Usage

---

### Perform Request

Using the API is simple. All you have to do is make a request. The API will return a response with the data you requested.

```javascript
var query = {
  date: "2023-06-15",
  changes: false
};

api.execute(query, function (error, data) {
    if (error) {
        return console.error(error);
    } else {
        console.log(data);
    }
});
```

---

### Using Promises

You can also use promises to make requests. The API returns a promise that you can use to handle the response.

```javascript
var query = {
  date: "2023-06-15",
  changes: false
};

api.execute(query)
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error(error);
    });
```

---

### Using Async/Await

You can also use async/await to make requests. The API returns a promise that you can use to handle the response.

```javascript
async function makeRequest() {
    var query = {
  date: "2023-06-15",
  changes: false
};

    try {
        const data = await api.execute(query);
        console.log(data);
    } catch (error) {
        console.error(error);
    }
}
```

---

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

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=npm&utm_medium=referral&utm_content=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=npm&utm_medium=referral&utm_content=readme) and [Privacy Policy](https://apiverve.com/privacy?utm_source=npm&utm_medium=referral&utm_content=readme).

---

## License
Licensed under the MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
