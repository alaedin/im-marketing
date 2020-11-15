package com.imm.report.generator.service.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import com.imm.report.generator.service.InvoiceReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class InvoiceReportServiceImpl implements InvoiceReportService {

	@SuppressWarnings("unchecked")
	@Override
	public byte[]  validApointments(List<?> values, Map<String, Object> parameters) throws JRException {
		return createReport(values, "/jasper/valid_apointment2.jrxml", parameters==null ? new HashedMap(): parameters);
	}

	@Override
	public byte[] createReport(List<?> values, String fileJRXMLClasspath, Map<String, Object> parameters)
			throws JRException {

		// Fetching the .jrxml file from the resources folder.
        InputStream stream = getClass().getResourceAsStream(fileJRXMLClasspath);
 
        // Compile the Jasper report from .jrxml to .japser
        JasperReport report = JasperCompileManager.compileReport(stream);
 
        // Fetching the employees from the data source.
        JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(values);
        
        parameters.put("appointment", source);
 
        JasperPrint print = JasperFillManager.fillReport(report, parameters, source);
 
        // Users can change as per their project requrirements or can take it as request input requirement.
        // For simplicity, this tutorial will automatically place the file under the "c:" drive.
        // If users want to download the pdf file on the browser, then they need to use the "Content-Disposition" technique.

        
        // Export the report to a PDF file.
         
		return JasperExportManager.exportReportToPdf(print);
	}

}
