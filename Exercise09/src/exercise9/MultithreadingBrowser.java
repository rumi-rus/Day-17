package exercise9;
import java.util.Scanner;

public class MultithreadingBrowser {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        Browser chrome=new Browser("www.googlechrome.com");
        Browser mozilla=new Browser("www.mozillafirefox.com");
        
        //Thread thread=new Thread(chrome);       
        System.out.println("name of first thread is "+chrome.getName());
        System.out.println("name of first thread is "+mozilla.getName());
        chrome.threadName=chrome.getName();
        mozilla.threadName=mozilla.getName();
        System.out.println("Enter the history to add:");
        for(int i=0;i<2;i++) {
        String url=sc.nextLine(); 
        chrome.History.add(url);
        mozilla.History.add(url);
        }
        chrome.start();
        mozilla.start();
	}
}
