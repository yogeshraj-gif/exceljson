publicclass LogicClass extends Student {
    String userDirectory = System.getProperty("user.dir");
    String pathSaparator = System.getProperty("file.separator");
    String filePath = userDirectory + pathSaparator + "src" + pathSaparator + "files" + pathSaparator + "records.";
    String ExcelfilePath = filePath + "xlsx";
    String jsonFilePath = filePath + "json";

    public void readTheJsonFile() {
        List<String> header = new ArrayList<>();
        List<String> student_Names = new ArrayList<>();
        List<Integer> student_Age = new ArrayList<>();
        List<Integer> student_Total_Marks = new ArrayList<>();

        String columnOne = "Name";
        String columnTwo = "Age";
        String columnThree = "Total_Marks";

        header.add(columnOne);
        header.add(columnTwo);
        header.add(columnThree);

        try {
            System.out.println("Read the json file");
            JSONParser parse = new JSONParser();
            FileReader fileReader = new FileReader(jsonFilePath);
            Object object = parse.parse(fileReader);
            JSONArray studentRecords = (JSONArray) object;
            for (Object recordObjects : studentRecords) {
                JSONObject student = (JSONObject) recordObjects;
                String name = (String) student.get(columnOne);
                student_Names.add(name);
                int age = Integer.parseInt(student.get(columnTwo).toString());
                student_Age.add(age);
                int TotalMarks = Integer.parseInt(student.get(columnThree).toString());
                student_Total_Marks.add(TotalMarks);
            }
            setHeader(header);
            setStudent_Names(student_Names);
            setStudent_Age(student_Age);
            setStudent_Total_Marks(student_Total_Marks);

        } catch (FileNotFoundException exception) {
            System.out.println("Check, if the file is present in the given path!");
        } catch (IOException | ParseException exception) {
            System.out.println("Check the file in the specified path.");
        }
    }

    public void generateExcelFile() {

        try {
            File fileObject = new File(ExcelfilePath);
            FileOutputStream file = new FileOutputStream(fileObject);
            Workbook work = new XSSFWorkbook();
            Sheet sheet = work.createSheet("Student Records");
            int numberOfRows = getStudent_Names().size() + 1;
            int numberOfColumns = getHeader().size();
            Row sheetHeader = sheet.createRow(0);
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                if (columnIndex == 0) {
                    Cell cellData = sheetHeader.createCell(columnIndex);
                    cellData.setCellValue(getHeader().get(columnIndex));
                } else if (columnIndex == 1) {
                    Cell cellData = sheetHeader.createCell(columnIndex);
                    cellData.setCellValue(getHeader().get(columnIndex));
                } else if (columnIndex == 2) {
                    Cell cellData = sheetHeader.createCell(columnIndex);
                    cellData.setCellValue(getHeader().get(columnIndex));
                }

            }
            for (int rowIndex = 1; rowIndex < numberOfRows; rowIndex++) {
                Row rowData = sheet.createRow(rowIndex);
                for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                    if (columnIndex == 0) {
                        Cell columnOne = rowData.createCell(columnIndex);
                        columnOne.setCellValue(getStudent_Names().get(rowIndex - 1));
                    } else if (columnIndex == 1) {
                        Cell columnTwo = rowData.createCell(columnIndex);
                        columnTwo.setCellValue(getStudent_Age().get(rowIndex - 1));
                    } else if (columnIndex == 2) {
                        Cell columnThree = rowData.createCell(columnIndex);
                        columnThree.setCellValue(getStudent_Total_Marks().get(rowIndex - 1));
                    }
                }
            }
            work.write(file);
            System.out.println("Excel file generated successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}