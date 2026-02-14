"""
National Debt API - Basic Usage Example

This example demonstrates the basic usage of the National Debt API.
API Documentation: https://docs.apiverve.com/ref/nationaldebt
"""

import os
import requests
import json

API_KEY = os.getenv('APIVERVE_API_KEY', 'YOUR_API_KEY_HERE')
API_URL = 'https://api.apiverve.com/v1/nationaldebt'

def call_nationaldebt_api():
    """
    Make a GET request to the National Debt API
    """
    try:
        headers = {
            'x-api-key': API_KEY
        }

        response = requests.get(API_URL, headers=headers)

        # Raise exception for HTTP errors
        response.raise_for_status()

        data = response.json()

        # Check API response status
        if data.get('status') == 'ok':
            print('✓ Success!')
            print('Response data:', json.dumps(data['data'], indent=2))
            return data['data']
        else:
            print('✗ API Error:', data.get('error', 'Unknown error'))
            return None

    except requests.exceptions.RequestException as e:
        print(f'✗ Request failed: {e}')
        return None

if __name__ == '__main__':
    print('📤 Calling National Debt API...\n')

    result = call_nationaldebt_api()

    if result:
        print('\n📊 Final Result:')
        print(json.dumps(result, indent=2))
    else:
        print('\n✗ API call failed')
