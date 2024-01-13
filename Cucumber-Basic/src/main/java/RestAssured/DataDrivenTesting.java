package RestAssured;

public class DataDrivenTesting {
	
	public void readDatafromExcel() {
	
	String excelPath = “C:\Users\Sudhanshu\git\Cucumber\Cucumber-Basic\src\main\java\utilities\DataforTest.xlsx”;

	String sheetName =”Sheet1";
	}
	
	String excelPath = “./data/DataForTesting.xlsx”;

	String sheetName =”Sheet1";

	ExcelUtils excel = new ExcelUtils(excelPath,sheetName);

	· Create a JSON object for request and add the data from excel to it,

	JSONObject request = new JSONObject();

	request.put(“name”, excel.getCellData(1,0));

	request.put(“job”, excel.getCellData(1,1));

	· Now we are going to make a request by having the request in the body and response will be assigned to a Response object.

	response = given().header(“Content-type”, “application/json”).and().body(request).when().post(BASE_URL).then().extract().response();

	· Get the response as string and store it in string variable

	String stringToParse = response.getBody().asString();

	· Using ObjectMapper, we are going to use readValue Method to deserialize JSON content from given JSON content String as below,

	ObjectMapper objectMapper = new ObjectMapper();

	UserInfo userInfo = objectMapper.readValue(stringToParse, UserInfo.class);

	· Pass this userinfo object to the method writeResponse. In this method we are going to write our response to an excel sheet.

	writeResponse(userInfo);

	· Create a new workbook and a worksheet as below,

	XSSFWorkbook workbook = new XSSFWorkbook();

	XSSFSheet sheet = workbook.createSheet(“Sheet1”);

	· Create a two dimensional object array,

	Object[][] respData = {

	{“User ID”, “User Name”, “Job”, “CreatedAt”},

	{userInfo.getId(), userInfo.getName(), userInfo.getJob(),userInfo.getCreatedAt() }

	};

	Create a rowcount variable and assign 0 as initial value,

	int rowCount = 0;

	· Using foreach loop, we are iterating through the object array and creating row and then column and setting the cellvalue

	for (Object[] rData : respData) {

	Row row = sheet.createRow(++rowCount);

	int columnCount = 0;

	for (Object field : rData) {

	Cell cell = row.createCell(++columnCount);

	if (field instanceof String) {

	cell.setCellValue((String) field);

	} else if (field instanceof Integer) {

	cell.setCellValue((Integer) field);

	}

	}

	}
}
