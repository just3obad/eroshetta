/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eroshetta;

import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Collection;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Administrator
 */
public class PrescriptionView extends javax.swing.JPanel implements Printable{
    static EntityManagerFactory emf = Eroshetta.emf;
    static EntityManager em = Eroshetta.em;
    Prescriptions presc;
    Collection<DrugTimes> dTimes;
   // Collection<Drugs> dCollec;
    /**
     * Creates new form PrescriptionView
     */
    public PrescriptionView() {
        initComponents();
    }
    public PrescriptionView(Prescriptions p)
    {
        initComponents();
         presc = p;
         dTimes = presc.getDrugTimesCollection();
    }
    public PrescriptionView(Prescriptions p,Collection<DrugTimes> times)
    {
        
        
        initComponents();
         presc = p;
         dTimes = times;
    }
    public Prescriptions getCurrentPresc()
    {
        return this.presc;
    }
    public Collection<DrugTimes> getDrugTimes()
    {
        return this.dTimes;
    }
//    public Collection<Drugs> getDrugColl()
//    {
//        return this.dCollec;
//    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
    m * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(153, 255, 102));
        setMaximumSize(new java.awt.Dimension(400, 688));
        setMinimumSize(new java.awt.Dimension(400, 688));
        setName("");
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(400, 688));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public int print(Graphics g, PageFormat pf, int pageIndex) {
      //assume the page exists until proven otherwise
      int retval = Printable.PAGE_EXISTS;
		
      //We only want to deal with the first page.
      //The first page is numbered '0'
      if (pageIndex > 0){
         retval = Printable.NO_SUCH_PAGE;
      } else {
         //setting up the Graphics object for printing
         g.translate((int)(pf.getImageableX()), (int)(pf.getImageableY()));
         //populate the Graphics object from HelloPrint's paint() method
         paint(g);
      }
		
      return retval;
   }
   public void paint(Graphics g) {
      
      super.paint(g);
      javax.persistence.Query q =em.createNamedQuery("Doctor.findAll");
      Doctor d =  (Doctor)q.getSingleResult();
      
     

      
//      javax.persistence.Query q1 =em.createNamedQuery("Prescriptions.findById");
//      q1.setParameter("id", 1);
//      Prescriptions p = (Prescriptions) q1.getSingleResult();
      
     
      
      
      Image img1;
      Image img2;
      Image img3;
      MediaTracker mt = new MediaTracker(this);
      img1 = Toolkit.getDefaultToolkit().getImage("t.gif");
      img2 = Toolkit.getDefaultToolkit().getImage("m.gif");
      img3 = Toolkit.getDefaultToolkit().getImage("a.gif");
      
      mt.addImage(img1,0);
      mt.addImage(img2, 0);
      mt.addImage(img3,0);
      
      Font font1 = new Font("Book Antiqua", Font.PLAIN, 30);
      Font font2 = new Font("Monotype Corsiva", Font.PLAIN, 20);
      
      g.setFont(font2);
      g.drawString("Dr. "+d.getName(),35,20);
      g.drawImage(img1,5,25,25,25, this);
      g.drawString(d.getOfficeNo(),35,50);
      g.drawImage(img2,5,55,25,25,this);
      g.drawString(d.getMobileNo(),35,80);
      g.drawString("Name: "+presc.getPatientId().getName(),35 ,115);
      g.drawString("Date: "+presc.getDate(),320,115);
      g.drawLine(50, 130, 570, 130);
      g.drawLine(50, 133, 570, 133);
      int h = 0;
      //System.out.println(presc.getDrugsCollection().size()+"<>");
      for(int i=0; i<dTimes.size() ; i++)
      {
          DrugTimes dTime = (DrugTimes) dTimes.toArray()[i];
          javax.persistence.Query q1 =em.createNamedQuery("Drugs.findById");
          q1.setParameter("id", dTime.drugTimesPK.getDrugId() );
          Drugs drug = (Drugs)q1.getSingleResult();
    
         
        //  Drugs drug  = (Drugs)presc.getDrugsCollection().toArray()[i];
          DrugTimes prescTime = (DrugTimes) dTimes.toArray()[i];
          g.drawString(prescTime.getDrugTime(),320,170+h);
          g.drawString(i+". "+drug.getTradeName(),10,170+h);
          h = h+30;
       
      }
      
      
      

      try{
      g.drawString(presc.getNotes(),10,550);
      }
      catch(Exception e)
      {
          
      }
      g.drawLine(50,600,570,600);
      g.drawLine(50,603,570,603);
      g.drawImage(img3,5,618,25,25, this);
      g.drawString(d.getAddress(),35,643);

      
      
      
      
      
   }

   
   
    
        
    }
    

