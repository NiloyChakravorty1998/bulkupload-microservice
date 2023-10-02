## __Bulk Upload Microservice__
The Bulk Upload Microservice is a RESTful API that allows users to upload Excel files containing data. This data is then processed and stored in a MySQL database and MongoDB. Sensitive information like Social Security Numbers (SSNs) is encrypted using an external API, and the encrypted IDs are stored in MySQL while the actual data is stored in MongoDB.

# __Features__
Bulk Upload: Upload Excel files containing data for processing.
Data Processing: Process uploaded data, including encrypting sensitive information.
MySQL Storage: Store encrypted sensitive information in MySQL.
MongoDB Storage: Store the actual data in MongoDB.
RESTful API: Provides endpoints for interacting with the microservice.
React Frontend: A frontend application for easy file uploads.

# __Prerequisites__
Before getting started, make sure you have the following prerequisites installed:

Node.js and npm
Java 8+
MySQL Server
MongoDB Server
React for the frontend
