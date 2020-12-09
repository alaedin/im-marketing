package com.imm.report.generator.controller;

import static org.springframework.http.MediaType.APPLICATION_PDF;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imm.report.generator.feign.client.PersonClient;
import com.imm.report.generator.feign.model.Appointment;
import com.imm.report.generator.service.InvoiceReportService;
import com.imm.report.generator.service.InvoiceService;
import com.imm.report.generator.service.MockOrderService;

import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("/report")
public class InvoiceController {

    @Resource
    private MockOrderService mockOrderService;
    @Resource
    private InvoiceService invoiceService;
//    
    @Autowired
    private InvoiceReportService invoiceReportService;
    
    @Autowired
    private PersonClient personClient;


	@SuppressWarnings("unchecked")
	@GetMapping("/{personId}/valid-appointment")
    public ResponseEntity<?> generateInvoice(@PathVariable("personId") Long personId){

		Map<String, Object>  response=  (Map<String, Object>) personClient.getByPerson(personId).getBody();
		List<Appointment> appointments = (List<Appointment>) response.get("body");
		System.out.println(appointments);
    	try {
			return new ResponseEntity<>(invoiceReportService.validApointments(appointments, null),
					getHttpHeaders("valid-appointment.pdf"), HttpStatus.OK);
		} catch (JRException e) {
			e.printStackTrace();
		}
    	return ResponseEntity.ok(null);
    }
   
	private HttpHeaders getHttpHeaders(String fileName) {
		HttpHeaders respHeaders = new HttpHeaders();
		respHeaders.setContentType(APPLICATION_PDF);
		respHeaders.add("content-disposition", "inline;filename=" + fileName);
		respHeaders.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		return respHeaders;
	}

	
}
