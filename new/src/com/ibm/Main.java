package com.ibm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import java.util.Scanner;
import java.util.Set;

import com.ibm.resources.CD;
import com.ibm.resources.Category;
import com.ibm.resources.Customer;
import com.ibm.resources.DVD;
import com.ibm.resources.Media;
import com.ibm.resources.PCGAME;
import com.ibm.resources.Transaction;

public class Main {
	 public static List<Transaction> transCollection;
	 public static List<Media> media ;
	 public static List<Customer> customers ; 
	 public final static String ADD_CUSTOMER = "addCustomer";
	 public final static String GET_CUSTOMERS = "getCustomers";
	 public final static String GET_CUSTOMER_BY_ID = "getCustomerById";
	 public final static String GET_ALL_MEDIA = "getAllMedia";
	 public final static String GET_MEDIA_BY_ID = "getMediaById";
	 public final static String GET_MEDIA_FROM_CATEGORY  = "getMediaFromCategory";
	 public final static String ADD_MEDIA  = "addMedia";
	 public final static String REMOVE_MEDIA  = "removeMedia";
	 public final static String GET_TRANSACTIONS = "getTransactions";
	 public final static String ADD_TRANSACTION = "addTransaction";
	 public final static String GET_MEDIA_CATEGORIES = "getMediaCategories";
	 
	 static{
		 transCollection = new ArrayList<Transaction>();
		 customers =  new ArrayList<Customer>();
		 media  = new ArrayList<Media>();
		 loadTransactionsFromFile();
		 loadMediaFile();
		 loadCustomersFromFile();
		 
		 
	 }
	public static void main(String[] args) {
		if (args.length==0){
				System.out.println("0 Arguments !\nChoose from the list below: :)\n-------------");
			 System.out.println("addCustomer\ngetCustomers\ngetCustomerById\ngetAllMedia\ngetMediaById\ngetMediaFromCategory\naddMedia\nremoveMedia\ngetTransactions\naddTransactions\ngetMediaCategories");
				
		} else{
			
		switch(args[0]){		
		
		case ADD_CUSTOMER:
			//addCustomer [firstName] [lastName] [phone]
			addCustomer(args[1]+" "+args[2],args[3]); 
			break; 
		case GET_CUSTOMERS:
			//getCustomers 
			//return customerID, name
			getAllCustomers(); 
			break;
		case GET_CUSTOMER_BY_ID:
			//getCustomerById [customerID]
			//return customerID, Name
			 getCustomer((Long.parseLong(args[1]))); 
			break;
		case GET_ALL_MEDIA:
			//getAllMedia 
			// return mediaID , Title
			getAllMedia(); 
			break;
		case GET_MEDIA_BY_ID:
			//getMediaById [mediaID]
			//return mediaID, Title
			getMediaById(Integer.parseInt(args[1])); 
			break;
		case GET_MEDIA_FROM_CATEGORY:
			//getMediaFromCategory [Category] 
			//mediaID, Title
			getMediaFromCategory(Category.valueOf(args[1]));
			break;
		case ADD_MEDIA:
			// DVD : addMedia [title] [note] [Category] [director] [length]
			// CD  : addMedia [title] [note] [Category] [interpreter] [length]
			// PCVIDEOSPIEL : addMedia [title] [note] [Category] [system]
			String cat=args[3].toUpperCase();
			if ((cat.equals("DVD"))||(cat.equals("CD"))){
			addMedia(args[1],args[2],args[3],args[4],args[5]); //title,note,cat,dir,len
			} else if (cat.equals("PCGAME")){  
				addMedia(args[1],args[2],args[3],args[4]);
			} 
			UpdateMediaFile();
			break;
		case REMOVE_MEDIA:	
			//removeMedia [mediaID]
			removeMedia(Integer.parseInt(args[1]));
			break;
		case GET_TRANSACTIONS:
			//getTransactions
			getAllTransactions();
			break;
		case ADD_TRANSACTION:
			//addTransaction [Type] [customerID] [mediaID]
			addTransaction(args[1],Long.valueOf(args[2]),Long.valueOf(args[3]));
			break;
		case GET_MEDIA_CATEGORIES:		
			//getMediaCategories
			//return Categories
			getMediaCategories();
			break;			
		default:
			System.out.println("Wrong command ! ");
		}
		 UpdateMediaFile();
		 updateCustomerFile();
		 updateTransactionFile();
		}
		
	}
		
	
	 public static void  loadTransactionsFromFile()
	 {
	
		 	try{
		 		Scanner scanner = new Scanner(new FileReader("Transaction.csv"));
		 		String line; 
		 		Transaction trans; 
		 		while(scanner.hasNextLine())
		 		{
		 			line=scanner.nextLine();
		 			String[] results = line.split(",");
		 			String data =results[0];
		 			DateFormat format = new SimpleDateFormat("MMMM d. yyyy");
		 			Date dateTransaction = format.parse(data);
		 			long idCstm=Long.parseLong(results[1]);
		 			long idMdia=Long.parseLong(results[2]);
		 			String transacType = results[3];
		 			trans = new Transaction(dateTransaction, idCstm, idMdia, transacType);
		 			transCollection.add(trans);
		 			
		 			}
		 	}
		 	catch(Exception e){
		 		System.out.println("Error: "+e.getMessage());
		 	}
		 
	 }
	 public static void loadMediaFile()
	 {
	 	
	 		try{
	 			Scanner scanner = new Scanner(new FileReader("Media.csv"));
	 			String line; 
	 			Media mdia;
	 		
	 			CD cd; 
	 			DVD dvd; 
	 			PCGAME pcv;
	 			while(scanner.hasNextLine())
	 			{
	 				line=scanner.nextLine();
	 				String[] results = line.split(",");
	 				long idMedia = Long.parseLong(results[0]);
	 				String titleMedia=results[1];
	 				String noteMedia=results[2];
	 				String categorieMedia=results[3];
	 			
	 			
	 				if(categorieMedia.contentEquals("CD"))
	 				{
	 					String interpreterCd=results[4];
	 					int lengthCd=Integer.parseInt(results[5]);
	 					cd= new CD(idMedia, titleMedia, noteMedia, Category.CD, interpreterCd, lengthCd);
	 					media.add(cd);
	 				}
	 				if(categorieMedia.contentEquals("DVD"))
	 				{
	 					String directorDvd=results[4];
	 					int lenthDvd =Integer.parseInt(results[5]);
	 					dvd = new DVD(idMedia, titleMedia, noteMedia, Category.DVD, directorDvd, lenthDvd);
	 					media.add(dvd);
	 				}
	 				if(categorieMedia.contentEquals("PCGAME"))
	 				{
	 					String systemPc = results[4];
	 					pcv = new PCGAME(idMedia, titleMedia, noteMedia, Category.PCGAME, systemPc);
	 					media.add(pcv);
	 				}
	 				
	 			}
	 		}
	 		catch(Exception e){
	 			System.out.println("Error: "+e.getMessage());
	 		}
	 	
	 }


	 public static void getAllTransactions(){
		 SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat dt2 = new SimpleDateFormat("MMMM d. yyyy");
		// new SimpleDateFormat("dd/MM/yyyy").format(new Date());  
			for(int i =0; i<transCollection.size();i++){
				int mediaID = (int) transCollection.get(i).getIdMedia();
				int idCustomer = (int) transCollection.get(i).getIdCustomer();
				Media m = null; 
				Customer c = null;
				
				for (int i1=0;i1<media.size();i1++){
					if (media.get(i1).getId()==mediaID){
						m = media.get(i1);
					}
				}
				 for (int i2 = 0; i2 < customers.size(); i2++) {
					if (customers.get(i2).getIdCustomer()==idCustomer){
						c = customers.get(i2);
					}
				}
				 
				 Transaction t =transCollection.get(i);
				if (m instanceof CD){
										 System.out.println(dt2.format(t.getTransactionDate())+": "+t.getTransactionType()+"\n"+m.getCategorie()+": \n\tTitle: "
								+	((CD)m).getTitle()+"\n\tInterpreter: "
								+	((CD)m).getInterpreter()+ "\nat "+dt1.format(t.getTransactionDate())
								+" rented by\n\tCustomer number: "+c.getIdCustomer()+"\n\tName: "+c.getName() );
				} else if (m instanceof DVD){
					 System.out.println(dt2.format(t.getTransactionDate())+": "+t.getTransactionType()+"\n"+m.getCategorie()+": \n\tTitle: "
								+	((DVD)m).getTitle()+"\n\tDirector: "
								+	((DVD)m).getDirector()+ "\nat "+dt1.format(t.getTransactionDate())
								+" rented by\n\tCustomer number: "+c.getIdCustomer()+"\n\tName: "+c.getName() );
				} else if (m instanceof PCGAME){
					 System.out.println(dt2.format(t.getTransactionDate())+": "+t.getTransactionType()+"\n"+m.getCategorie()+": \n\tTitle: "
								+	((PCGAME)m).getTitle()+"\n\tSystem: "
								+	((PCGAME)m).getSystem()+ "\nat "+dt1.format(t.getTransactionDate())
								+" rented by\n\tCustomer number: "+c.getIdCustomer()+"\n\tName: "+c.getName() );
				}
				System.out.println("------------------------------------------");
			}
	 }
	 public static void getAllMedia()
	 {	
	 		for(int i=0;i<media.size();i++)	 			 
	 			System.out.println(media.get(i).getId()+" "+media.get(i).getTitle());
	 }
	 public static void loadCustomersFromFile()
	 {	
	 	try{
	 		Scanner scanner = new Scanner(new FileReader("Customers.csv"));
	 		String line; 
	 		Customer cstm; 
	 		while(scanner.hasNextLine())
	 		{
	 			line=scanner.nextLine();
	 			String[] results = line.split(",");
	 			long id = Long.parseLong(results[0]);
	 			String nameBuff=results[1];
	 			String phoneBuff=results[2];
	 			cstm= new Customer(id, nameBuff, phoneBuff);
	 			customers.add(cstm);
	 			}
	 	}
	 	catch(Exception e){
	 		System.out.println("Error: "+e.getMessage());
	 	}
	 }
	 public static void getAllCustomers(){
	 	for(int i=0;i<customers.size();i++)
	 		System.out.println(customers.get(i).getIdCustomer()+" "+customers.get(i).getName());
	 }
	 public static void getMediaFromCategory(Category c){
		 for (Media m : media) {
			 if(m.getCategorie().equals(c)){
				 System.out.println(m.getId()+" "+m.getTitle());
			 }
		 
		}
	 }
	 
	 public static void getMediaById(int id){
		 for (Media m : media) {
			if (m.getId()==id){
				if (m instanceof CD){
					System.out.println(((CD) m).getId()+" "+((CD)m).getTitle()+""
							+ " "+((CD)m).getInterpreter());
				}else if (m instanceof DVD){
					System.out.println(((DVD) m).getId()+" "+((DVD)m).getTitle()+""
							+ " "+((DVD)m).getDirector());
				} else if (m instanceof PCGAME){
					System.out.println(((PCGAME) m).getId()+" "+((DVD)m).getTitle()+""
							+ " "+((PCGAME)m).getSystem());
				}
			}
		}
	 }
	 public static void getMediaCategories(){
		 Set<Category> set=new HashSet<Category>();
		 for (Media m : media) {
			 set.add(m.getCategorie());
		 }
		 for (Category c : set) {
			System.out.println(c.toString());
		}
	 }
	 public static void removeMedia(int id){
		 for (final Iterator<Media> iterator = media.iterator(); iterator.hasNext(); ) {
			    if (iterator.next().getId()==id) {
			        iterator.remove();
			    }
			}
		  
	 }
	 public static void UpdateMediaFile(){
		 StringBuilder sb=new StringBuilder();
		 for (Media m : media) {
			sb.append(m);
			sb.append("\n");
		}		 
		 String str=String.valueOf(sb.deleteCharAt(sb.length()-1));		 	 
		 PrintWriter out = null;
		try {
			out = new PrintWriter("Media.csv");
			out.write(str);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
		  
		 
	 }
	 public static void addMedia(Object...a){
		 //CD :id,title,note,cat,interpr,length
		//DVD :id,title,note,cat,direct,length
		//VG :id,title,note,cat,system
		 Category c=Category.valueOf((String) a[2]);
		 int lastIndex=(int) media.get(media.size()-1).getId();
	//	 System.out.println(lastIndex+" "+c);
		switch(c){
		case DVD:
			media.add(new DVD(++lastIndex,String.valueOf(a[0]),String.valueOf(a[1]),Category.DVD,String.valueOf(a[3]),Integer.valueOf((String) a[4])));
			break;
		case CD:
			media.add(new CD(++lastIndex,String.valueOf(a[0]),String.valueOf(a[1]),Category.CD,String.valueOf(a[3]),Integer.valueOf((String) a[4])));
			break;
		case PCGAME:
			media.add(new PCGAME(++lastIndex,String.valueOf(a[0]),String.valueOf(a[1]),Category.PCGAME,String.valueOf(a[3])));
			break;
			default:
				System.out.println("def");
		}
		
	 }
	 public static void addCustomer(String name,String phone){
		 int lastIndex = (int) customers.get(customers.size()-1).getIdCustomer();
		 customers.add(new Customer(++lastIndex, name, phone));		 
	 }
	 public static void updateCustomerFile(){
		 StringBuilder sb=new StringBuilder();
		 for (Customer m : customers) {
			sb.append(m);
			sb.append("\n");
		}		 
		 String str=String.valueOf(sb.deleteCharAt(sb.length()-1));		 	 
		 PrintWriter out = null;
		try {
			out = new PrintWriter("Customers.csv");
			out.write(str);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	 }
	 public static void addTransaction(String type,long userId,long mediaId){		 
		 Date date = new Date();		 
		 transCollection.add(new Transaction(date,userId,mediaId,type));
	 }
	 public static void updateTransactionFile(){
		 StringBuilder sb=new StringBuilder();
		 for (Transaction m : transCollection) {
			sb.append(m);
			sb.append("\n");
		}		 
		 String str=String.valueOf(sb.deleteCharAt(sb.length()-1));		 	 
		 PrintWriter out = null;
		try {
			out = new PrintWriter("Transaction.csv");
			out.write(str);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	 }
	 public static void getCustomer(long id){
		 for (Customer customer : customers) {
			if (customer.getIdCustomer()==id){
				System.out.println(customer.getIdCustomer()+" "+customer.getName() );
			}
		}
	 }
}
