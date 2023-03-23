package exercise9;
import java.util.ArrayList;
import java.util.Scanner;

public class Browser extends Thread{
	
	 public String threadName;
     ArrayList<String> History=new ArrayList<String>();
     Scanner sc=new Scanner(System.in);

     Browser(String url){
	    History.add(url);
     }
     void setHistory(String url) {
	    History.add(url);
     }
     void deleteHistory(String url) throws Exception {
    	 System.out.println("Inside Delete function:\n");
    	 if(History.contains(url)) {
	        History.remove(url);
	        System.out.println("deletion Complete\n ");
    	 }
    	 else {
    		 throw new Exception("Invalid url");
    	 }
     }
     void readHistory() {
	    for(String s:History) {
		   System.out.println(s);
	    }
     }
     @Override
     public void run() {
	   if( threadName.equals("Thread-0") ){
	       System.out.println("enter the url to delete: ");
		   String str=sc.nextLine();
		   try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
           try {
			   deleteHistory(str);
			   readHistory();
		   } catch (Exception e) {
			   e.printStackTrace();
		   }   
        }
       else if( threadName.equals("Thread-1" )){
        	System.out.println("reading: ");
           
            try {
			    Thread.sleep(5000);
		    } catch (InterruptedException e) {
			    e.printStackTrace();
		    }
            readHistory();
       }    
     }
}
