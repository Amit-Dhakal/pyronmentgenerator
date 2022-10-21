package com.example.PyronmentDocumentGenerator.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PyronmentDocumentGenerator.model.PyronmentData;
import com.example.PyronmentDocumentGenerator.repo.PyronmentDocsRepo;

@Service
public class PyronmentReader implements PyronmentService{

	@Autowired
	PyronmentDocsRepo pyronmentDocsRepo;
	
	
	PyronmentData pyronmentData=new PyronmentData();	

	@Override
	public void saveData() {
		// TODO Auto-generated method stub
		
	try {		
				String fileName="C:\\KYC Task\\KYC-FACT_FIND_PYRMONT-SINGLE.docx";			
			   FileInputStream fis = new FileInputStream("C:\\KYC Task\\KYC-FACT_FIND_PYRMONT-SINGLE.docx");
			  XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
			   XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
			   
		      String docText = extractor.getText();		      
		 	  List<String> dataList=new ArrayList<String>(); 	  
		      String[] Linelist = extractor.getText().split("\n");
		 	  
		        for(String str : Linelist){
		        			        		        		
		        	if(str.contains("{") && str.contains("}")) {
		        				      
		        	  int firstInd=str.indexOf('{');
		              int secInd=str.indexOf('}');     		             		            				 
		              String subDocText=str.substring(firstInd+1,secInd);
		         //     System.out.println(subDocText);
		              dataList.add(subDocText);
		                  
		              
		        	}
		        	
		        }
		        
		        pyronmentData.setClientFullName(dataList.get(0));
		        pyronmentData.setCompletionDate(dataList.get(1));
		        pyronmentData.setAdviserName(dataList.get(2));
		        pyronmentData.setAddress(dataList.get(3));
	            
		        //contact details 
		        pyronmentData.setPhone(dataList.get(4));
		        pyronmentData.setEmail(dataList.get(5));	
		        pyronmentData.setWebsite(dataList.get(6));	
		        pyronmentData.setTitle(dataList.get(7));
		        pyronmentData.setClientFirstandSecondName(dataList.get(8));
		        pyronmentData.setFamilyName(dataList.get(9));
		        pyronmentData.setDateofbirth(dataList.get(10));	 
		        pyronmentData.setGender(dataList.get(11));   
		        pyronmentData.setMaritalstatus(dataList.get(12));
		        pyronmentData.setPassportnumber(dataList.get(13));
		        pyronmentData.setCountry(dataList.get(15));	 
		       		        
		        //address	        
		        pyronmentData.setResidentialAddressone(dataList.get(16));
		        pyronmentData.setResidentialAddresstwo(dataList.get(17));
		        pyronmentData.setCorrespondenceAddressone(dataList.get(18));
		        pyronmentData.setCorrespondenceAddresstwo(dataList.get(19));
		        pyronmentData.setCountry(dataList.get(20));	 
		        pyronmentData.setResdentialStatus(dataList.get(21));  
		        pyronmentData.setSecondaryEmail(dataList.get(22));
        	        
		        
		           
		  pyronmentDocsRepo.insert(pyronmentData);
		 
			} catch(Exception ex) {
			    ex.printStackTrace();
			}
	  

	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub
		
		
		PyronmentReader pyronmentReader =new PyronmentReader();
		pyronmentReader.saveData();
		
		
		
	}


	}


