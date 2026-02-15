from setuptools import setup, find_packages

setup(
    name='apiverve_nationaldebt',
    version='1.1.13',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='National Debt provides real-time access to the US national debt (Debt to the Penny). It returns the total public debt, debt held by the public, intragovernmental holdings, and per-capita debt calculations.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/nationaldebt?utm_source=pypi&utm_medium=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
