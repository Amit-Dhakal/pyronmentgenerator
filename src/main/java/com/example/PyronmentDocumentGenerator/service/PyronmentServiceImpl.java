package com.example.PyronmentDocumentGenerator.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.core.io.ClassPathResource;



public class PyronmentServiceImpl {

	
//private static final Logger LOGGER = LoggerFactory.getLogger(WordService.class);
  
    
    private static final int String = 0;





	/**
     * Method for generating DocX report by replacing data in existing template
     *
     * @param docXTemplateFileWithExtension given name of docX template with extension
     * @param dataParams given map of data parameters that need to be replacement for docX placeholders
     * @return generated report name
     * @throws IOException input|output exception
     **/
    public void generateReport( Map<String,String> dataParams) throws IOException
    {
        // get docx template from file system
      //  ClassPathResource pathResource = new ClassPathResource("your_folder_name/" + docXTemplateFileWithExtension);
      //  InputStream inputStream = pathResource.getInputStream();
        
		File pathResource=new File("C:\\KYC Task\\KYC-FACT_FIND_PYRMONT-SINGLE.docx");

		FileInputStream inputStream = new FileInputStream(pathResource);

        
        
        
        ZipSecureFile.setMinInflateRatio(-1.0d);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (XWPFDocument xwpfDocument = new XWPFDocument(inputStream))
        {
            replacePlaceholdersInParagraphs(dataParams, xwpfDocument);
            replacePlaceholderInTables(dataParams, xwpfDocument);

            xwpfDocument.write(outputStream);

            // generate file name
       //     String generatedFileName = "report".concat("_").concat(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).concat(".").concat("docx") );
            
            // store report to file system
            Path path = Paths.get("D:\\test\\test.docx");
            Files.write(path, outputStream.toByteArray());

         //   return Optional.ofNullable(generatedFileName);
            
            
        }
        catch (Exception e)
        {
          //  LOGGER.error("Error occurred while generating report: {}", e.getMessage());
            //return Optional.empty();
        	
        	System.out.println(e);
        }
    }

    /**
     * Method for replacing docx placeholders with given data parameters in every docx paragraph
     *
     * @param dataParams given data to be replaced with template placeholders
     * @param xwpfDocument docx template document
     **/
    private void replacePlaceholdersInParagraphs(Map<String,String> dataParams, XWPFDocument xwpfDocument)
    {
    	
    	System.out.println("Data params are:"+dataParams);
    	
        for (Map.Entry<String,String> entry : dataParams.entrySet())
        {
            for (XWPFParagraph paragraph : xwpfDocument.getParagraphs())
            {
                for (XWPFRun run : paragraph.getRuns())
                {
                    String text = run.text();
                    
                    if (text != null&& text.contains(entry.getKey())&& entry.getValue() != null && !entry.getValue().isEmpty())
                    {
                       text = text.replace(entry.getKey(),entry.getValue());
                       run.setText(text, 0);
                    }
                }
            }
        }
    }

    /**
     * Method for replacing docx placeholders with given data parameters in docx table
     *
     * @param dataParams given data to be replaced with template placeholders
     * @param xwpfDocument docx template document
     **/
    private void replacePlaceholderInTables(Map<String,String> dataParams, XWPFDocument xwpfDocument)
    {
        for (Map.Entry<String, String> entry : dataParams.entrySet())
        {
            for (XWPFTable xwpfTable : xwpfDocument.getTables())
            {
                for (XWPFTableRow xwpfTableRow : xwpfTable.getRows())
                {
                    for (XWPFTableCell xwpfTableCell : xwpfTableRow.getTableCells())
                    {
                        for (XWPFParagraph xwpfParagraph : xwpfTableCell.getParagraphs())
                        {
                            for (XWPFRun xwpfRun : xwpfParagraph.getRuns())
                            {
                                String text = xwpfRun.text();
                                if (
                                    text != null
                                        && text.contains(entry.getKey())
                                        && entry.getValue() != null
                                        && !entry.getValue().isEmpty()
                                    )
                                {
                                    text = text.replace(entry.getKey(), entry.getValue());
                                    xwpfRun.setText(text, 0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
	
	
	

	
	public static void main(String[] args) {
		PyronmentServiceImpl pyronmentServiceImpl =new PyronmentServiceImpl();
      //  ClassPathResource pathResource = new ClassPathResource("KYC-FACT_FIND_PYRMONT-SINGLE.docx");
		
		File pathResource=new File("C:\\KYC Task\\KYC-FACT_FIND_PYRMONT-SINGLE.docx");
		
		
        Map<String,String> dataParams=new HashedMap<String,String>();
        dataParams.put("client_salutation","MR");
        dataParams.put("report_issued_date","10/19/2022");
        dataParams.put("setting_adviser_name","Amit Dhakal");

		try {
			FileInputStream inputStream = new FileInputStream(pathResource);

	        //InputStream inputStream = new ClassPathResource("/PyronmentDocumentGenerator/src/main/resources/templates/KYC-FACT_FIND_PYRMONT-SINGLE.docx").getInputStream();
			
			
		       XWPFDocument xwpfDocument = new XWPFDocument(inputStream);
				pyronmentServiceImpl.replacePlaceholdersInParagraphs(dataParams,xwpfDocument);
				
				pyronmentServiceImpl.generateReport(dataParams);
				
				
				System.out.println("success");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      	
	}

	}