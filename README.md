# pivotPoints
This is an Rest API which takes stock market data and generates the pivot highs and lows based on the user input for no of days.

## Steps to Run
1. Download the zip file with the code and import in intelliJ
2. Do the gradle build using ../gradlew build
3. Run the application (currently configured to listen to port 8091)
4. Open swagger UI http://localhost:8091/swagger-ui/index.html
5. Try the pivot points Get API 
   Sample inputs : fileName - data
                   noOfdays - 2
6. The API will return the JSON output string containing the PivotHighs and PivotLows data

