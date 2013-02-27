package com.medicalmanager.controllers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;

import com.medicalmanager.models.Patient;
import com.medicalmanager.views.PatientView;

public class Print implements Printable {
	boolean all = false;
	
	public Print(boolean all){
		this.all = all;
	}
	
	public int print(Graphics g, PageFormat pf, int pageIndex) {
		if (pageIndex != 0){
			return NO_SUCH_PAGE;
		}
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setFont(new Font("Serif", Font.PLAIN, 36));
		g2.setPaint(Color.black);
		g2.drawString("Medical Manager Patient Printout", 50, 100);
		
		if(all){
			int y = 200;
			int x = 150;
			
			g2.setFont(new Font("Serif", Font.PLAIN, 20));
			
			for(Patient p: PatientView.getPatientArray()){
				g2.drawString("-----------------------", x, y);
				y += 50;
				g2.drawString("Name: => " + p.getFullName(), x, y);
				y += 50;
				g2.drawString("Age: =>" + p.getAge(), x, y);
				y += 50;
				g2.drawString("Email: => " + p.getEmailAddress(), x, y);
				y += 50;
				g2.drawString("-----------------------", x, y);
				y += 100;
			}
		} else {
		    Patient p = PatientView.getSelected();
			
			int y = 200;
			int x = 150;
			
			g2.setFont(new Font("Serif", Font.PLAIN, 20));
			g2.drawString("-----------------------", x, y);
			y += 50;
			g2.drawString("Name: => " + p.getFullName(), x, y);
			y += 50;
			g2.drawString("Age: =>" + p.getAge(), x, y);
			y += 50;
			g2.drawString("Email: => " + p.getEmailAddress(), x, y);
			y += 50;
			g2.drawString("-----------------------", x, y);
			y += 100;
		}
		
		Rectangle2D outline = new Rectangle2D.Double(pf.getImageableX(), 
				pf.getImageableY(), 
				pf.getImageableWidth(),
				pf.getImageableHeight());
		
		g2.draw(outline);
		
		return PAGE_EXISTS;
	  }
}