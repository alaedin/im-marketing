package com.imm.report.generator.service;

import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

public interface InvoiceReportService {

	byte[] createReport(List<?> values, String fileJRXMLClasspath, Map<String, Object> parameters) throws JRException;

	byte[] validApointments(List<?> values, Map<String, Object> parameters) throws JRException;

}
