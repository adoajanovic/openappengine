/**
 * 
 */
package com.openappengine.fms.print;

import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.Sides;

/**
 * @author hrishi
 *
 */
public class PrintingServiceFacadeImpl implements PrintingServiceFacade {
	
	@Override
	public void printDocument(byte[] bytes) {
		DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
		
		PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
		if(ps == null) {
			throw new PrintingServiceException("Could not find a default printer. Please check.");
		}
		DocPrintJob printJob = ps.createPrintJob();
		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
	    aset.add(new Copies(1));
	    aset.add(Sides.ONE_SIDED);
	    
	    SimpleDoc simpleDoc = null;
		simpleDoc = new SimpleDoc(bytes, flavor, null);
		
	    try {
			printJob.print(simpleDoc, null);
		} catch (PrintException e) {
			throw new PrintingServiceException("Error while printing the document.",e);
		}
	}

	public static void main(String[] args) throws PrinterException, PrintException, FileNotFoundException, MalformedURLException {
		DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE;
		PrintRequestAttributeSet patts = new HashPrintRequestAttributeSet();
		patts.add(Sides.DUPLEX);
		PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
		DocPrintJob printJob = ps.createPrintJob();
		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
	    aset.add(new Copies(1));
	    aset.add(Sides.ONE_SIDED);
	    
	    File pdfFile = new File("F:\\Order.pdf");
	    SimpleDoc simpleDoc = new SimpleDoc(pdfFile.toURL(), flavor, null);
	    printJob.print(simpleDoc, null);
	}
	
}
